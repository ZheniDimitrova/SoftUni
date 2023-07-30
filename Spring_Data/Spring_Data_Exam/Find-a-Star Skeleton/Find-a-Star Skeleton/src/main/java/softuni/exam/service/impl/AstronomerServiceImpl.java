package softuni.exam.service.impl;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.AstronomersImportDto;
import softuni.exam.models.dto.AstronomersRootDto;
import softuni.exam.models.entity.Astronomer;
import softuni.exam.models.entity.Star;
import softuni.exam.repository.AstronomerRepository;
import softuni.exam.repository.StarRepository;
import softuni.exam.service.AstronomerService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class AstronomerServiceImpl implements AstronomerService {

    private static final String ASTRONOMERS_FILE_PATH = "src/main/resources/files/xml/astronomers.xml";

   private final AstronomerRepository astronomerRepository;
   private final StarRepository starRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;



    public AstronomerServiceImpl(AstronomerRepository astronomerRepository, StarRepository starRepository, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.astronomerRepository = astronomerRepository;
        this.starRepository = starRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return astronomerRepository.count() > 0;
    }

    @Override
    public String readAstronomersFromFile() throws IOException {
        return Files.readString(Path.of(ASTRONOMERS_FILE_PATH));
    }

    @Override
    public String importAstronomers() throws IOException, JAXBException {
        StringBuilder out = new StringBuilder();

        AstronomersRootDto astronomersRootDto = xmlParser.fromFile(ASTRONOMERS_FILE_PATH, AstronomersRootDto.class);
        List<AstronomersImportDto> astronomersImportDtoList = astronomersRootDto.getAstronomers();

        for (AstronomersImportDto astronomersImportDto : astronomersImportDtoList) {

            if (!validationUtil.isValid(astronomersImportDto) || astronomerRepository.findByFirstNameAndLastName(astronomersImportDto.getFirstName(),
                    astronomersImportDto.getLastName()) != null || starRepository.findById(astronomersImportDto.getObservingStar()).isEmpty()) {
                out.append("Invalid astronomer").append(System.lineSeparator());

            } else {
                Astronomer astronomer = modelMapper.map(astronomersImportDto, Astronomer.class);
                Star star = starRepository.findById(astronomersImportDto.getObservingStar()).get();
                astronomer.setObservingStar(star);
                astronomerRepository.save(astronomer);

                out.append(String.format("Successfully imported astronomer %s %s - %.2f",
                        astronomer.getFirstName(),
                        astronomer.getLastName(),
                        astronomer.getAverageObservationHours()))
                        .append(System.lineSeparator());
            }
        }

        return out.toString().trim();
    }
}
