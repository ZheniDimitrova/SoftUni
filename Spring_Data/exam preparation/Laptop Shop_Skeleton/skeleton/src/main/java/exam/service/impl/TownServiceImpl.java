package exam.service.impl;

import exam.model.dto.TownsImportDto;
import exam.model.dto.TownsRootDto;
import exam.model.entity.Town;
import exam.repository.TownRepository;
import exam.service.TownService;
import exam.util.ValidationUtil;
import exam.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


@Service
public class TownServiceImpl implements TownService {

    private static final  String TOWNS_FILE_PATH = "src/main/resources/files/xml/towns.xml";
    private final TownRepository townRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private  final ValidationUtil validationUtil;

    public TownServiceImpl(TownRepository townRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtil validationUtil) {
        this.townRepository = townRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
    }


    @Override
    public boolean areImported() {
        return townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(Path.of(TOWNS_FILE_PATH));
    }

    @Override
    public String importTowns() throws JAXBException, FileNotFoundException {

        StringBuilder out = new StringBuilder();

        TownsRootDto townsRootDto = xmlParser.fromFile(TOWNS_FILE_PATH, TownsRootDto.class);
        List<TownsImportDto> townsImportDtoList = townsRootDto.getTowns();

        for (TownsImportDto townsImportDto : townsImportDtoList) {
            if (!validationUtil.isValid(townsImportDto)) {
                out.append("Invalid town")
                        .append(System.lineSeparator());

            } else {
                Town town = modelMapper.map(townsImportDto, Town.class);
                townRepository.save(town);

                out.append(String.format("Successfully imported Town %s",
                                town.getName()))
                        .append(System.lineSeparator());
            }
        }

        return out.toString().trim();
    }
}
