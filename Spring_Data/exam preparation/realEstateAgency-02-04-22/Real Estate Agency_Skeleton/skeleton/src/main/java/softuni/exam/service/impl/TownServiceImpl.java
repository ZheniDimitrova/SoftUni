package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.TownImportDto;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class TownServiceImpl implements TownService {

    private static final String TOWN_PATH_FILE = "src/main/resources/files/json/towns.json";
    private final TownRepository townRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;

    private final ValidationUtil validationUtil;

    public TownServiceImpl(TownRepository townRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.townRepository = townRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(Path.of(TOWN_PATH_FILE));
    }

    @Override
    public String importTowns() throws IOException {
        StringBuilder builder = new StringBuilder();

        TownImportDto[] townImportDtoS = gson.fromJson(readTownsFileContent(), TownImportDto[].class);

        for(TownImportDto townImportDto : townImportDtoS) {
            if(!validationUtil.isValid(townImportDto)) {
              builder.append("Invalid town").append(System.lineSeparator());
            } else {
               Town town = modelMapper.map(townImportDto, Town.class);
               townRepository.save(town);

               builder.append(String.format("Successfully imported town %s - %d",
               town.getTownName(), town.getPopulation()))
                       .append(System.lineSeparator());
            }

        }

        return builder.toString().trim();
    }
}
