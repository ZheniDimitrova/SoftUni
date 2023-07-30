package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ConstellationsImportDto;
import softuni.exam.models.entity.Constellation;
import softuni.exam.repository.ConstellationRepository;
import softuni.exam.service.ConstellationService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class ConstellationServiceImpl implements ConstellationService {
    private static final String CONSTELLATIONS_FILE_PATH = "src/main/resources/files/json/constellations.json";

    private final ConstellationRepository constellationRepository;
    private final Gson gson;
        private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public ConstellationServiceImpl(ConstellationRepository constellationRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.constellationRepository = constellationRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return constellationRepository.count() > 0;
    }

    @Override
    public String readConstellationsFromFile() throws IOException {
        return Files.readString(Path.of(CONSTELLATIONS_FILE_PATH));
    }

    @Override
    public String importConstellations() throws IOException {

        StringBuilder out = new StringBuilder();

        ConstellationsImportDto[] constellationsImportDtoS = gson.fromJson(readConstellationsFromFile(), ConstellationsImportDto[].class);

        for(ConstellationsImportDto constellationsImportDto : constellationsImportDtoS) {

            if(!validationUtil.isValid(constellationsImportDto) || constellationRepository.findByName(constellationsImportDto.getName()) != null) {
                out.append("Invalid constellation").append(System.lineSeparator());

            } else {
                Constellation constellation = modelMapper.map(constellationsImportDto, Constellation.class);
                constellationRepository.save(constellation);

                out.append(String.format("Successfully imported constellation %s - %s",
                        constellation.getName(), constellation.getDescription()))
                        .append(System.lineSeparator());
            }
        }
        return out.toString().trim();
    }
}
