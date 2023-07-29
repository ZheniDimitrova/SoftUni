package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.MechanicsImportDto;
import softuni.exam.models.entity.Mechanic;
import softuni.exam.repository.MechanicsRepository;
import softuni.exam.service.MechanicsService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


@Service
public class MechanicsServiceImpl implements MechanicsService {
    private static String MECHANICS_FILE_PATH = "src/main/resources/files/json/mechanics.json";

    private final MechanicsRepository mechanicsRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public MechanicsServiceImpl(MechanicsRepository mechanicsRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.mechanicsRepository = mechanicsRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return mechanicsRepository.count() > 0;
    }

    @Override
    public String readMechanicsFromFile() throws IOException {
        return Files.readString(Path.of(MECHANICS_FILE_PATH));
    }

    @Override
    public String importMechanics() throws IOException {
        StringBuilder builder = new StringBuilder();

        MechanicsImportDto[] mechanicsImportDtoS = gson.fromJson(readMechanicsFromFile(), MechanicsImportDto[].class);

        for(MechanicsImportDto mechanicsImportDto : mechanicsImportDtoS) {

            if(!validationUtil.isValid(mechanicsImportDto) || mechanicsRepository.findByEmail(mechanicsImportDto.getEmail()) != null) {
                builder.append("Invalid mechanic")
                        .append(System.lineSeparator());

            } else {
                Mechanic mechanic = modelMapper.map(mechanicsImportDto, Mechanic.class);
                mechanicsRepository.save(mechanic);

                builder.append(String.format("Successfully imported mechanic %s %s",
                        mechanic.getFirstName(),
                        mechanic.getLastName()))
                        .append(System.lineSeparator());
            }
        }
        return builder.toString().trim();
    }
}
