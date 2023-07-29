package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.PartsImportDto;
import softuni.exam.models.entity.Part;
import softuni.exam.repository.PartsRepository;
import softuni.exam.service.PartsService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


@Service
public class PartsServiceImpl implements PartsService {

    private static String PARTS_FILE_PATH = "src/main/resources/files/json/parts.json";

    private final PartsRepository partsRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public PartsServiceImpl(PartsRepository partsRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.partsRepository = partsRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return partsRepository.count() > 0;
    }

    @Override
    public String readPartsFileContent() throws IOException {
        return Files.readString(Path.of(PARTS_FILE_PATH));
    }

    @Override
    public String importParts() throws IOException {
        StringBuilder builder = new StringBuilder();

        PartsImportDto[] partsImportDtoS = gson.fromJson(readPartsFileContent(), PartsImportDto[].class);

        for (PartsImportDto partsImportDto: partsImportDtoS) {

            if(!validationUtil.isValid(partsImportDto) || partsRepository.findByPartName(partsImportDto.getPartName()) != null) {
                builder.append("Invalid part")
                        .append(System.lineSeparator());

            } else {
                Part part = modelMapper.map(partsImportDto, Part.class);
                partsRepository.save(part);

                builder.append(String.format("Successfully imported part %s - ",
                        part.getPartName()) + part.getPrice())
                        .append(System.lineSeparator());
            }
        }
        return builder.toString().trim();
    }
}
