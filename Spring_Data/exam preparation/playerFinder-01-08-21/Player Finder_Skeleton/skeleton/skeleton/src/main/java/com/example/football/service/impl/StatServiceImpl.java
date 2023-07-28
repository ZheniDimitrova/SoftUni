package com.example.football.service.impl;

import com.example.football.models.dto.StatsImportDto;
import com.example.football.models.dto.StatsRootDto;
import com.example.football.models.entity.Stat;
import com.example.football.repository.StatRepository;
import com.example.football.service.StatService;
import com.example.football.util.ValidationUtil;
import com.example.football.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class StatServiceImpl implements StatService {
    private static final String STATS_FILE_PATH = "src/main/resources/files/xml/stats.xml";

    private final StatRepository statRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public StatServiceImpl(StatRepository statRepository, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.statRepository = statRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }


    @Override
    public boolean areImported() {
        return statRepository.count() > 0;
    }

    @Override
    public String readStatsFileContent() throws IOException {
        return Files.readString(Path.of(STATS_FILE_PATH));
    }

    @Override
    public String importStats() throws JAXBException {
        StringBuilder sb = new StringBuilder();

        StatsRootDto statsRootDto = xmlParser.fromFile(STATS_FILE_PATH, StatsRootDto.class);
        List<StatsImportDto> statsImportDtoS = statsRootDto.getStats();

        for(StatsImportDto statsImportDto : statsImportDtoS) {

            if(!validationUtil.isValid(statsImportDto) || statRepository.findByPassingAndShootingAndEndurance(statsImportDto.getPassing(),
                    statsImportDto.getShooting(), statsImportDto.getEndurance()) != null){
                sb.append("Invalid Stat")
                        .append(System.lineSeparator());

            } else {
                Stat stat = modelMapper.map(statsImportDto, Stat.class);
                statRepository.save(stat);

                sb.append(String.format("Successfully imported Stat %.2f - %.2f - %.2f",
                        stat.getShooting(),
                        stat.getPassing(),
                        stat.getEndurance()))
                        .append(System.lineSeparator());
            }
        }

        return sb.toString().trim();
    }
}
