package com.example.football.service.impl;

import com.example.football.models.dto.TownsImportDto;
import com.example.football.models.entity.Town;
import com.example.football.repository.TownRepository;
import com.example.football.service.TownService;
import com.example.football.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


@Service
public class TownServiceImpl implements TownService {
    private static final String TOWNS_FILE_PATH = "src/main/resources/files/json/towns.json";

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
        return Files.readString(Path.of(TOWNS_FILE_PATH));
    }

    @Override
    public String importTowns() throws IOException {
        StringBuilder sb = new StringBuilder();

        TownsImportDto[] townsImportDtoS = gson.fromJson(readTownsFileContent(), TownsImportDto[].class);

        for (TownsImportDto townsImportDto : townsImportDtoS) {

            if(!validationUtil.isValid(townsImportDto) || townRepository.findByName(townsImportDto.getName()) != null) {
                sb.append("Invalid Town")
                        .append(System.lineSeparator());

            } else {
                Town town = modelMapper.map(townsImportDto, Town.class);
                townRepository.save(town);

                sb.append(String.format("Successfully imported Town %s - %d",
                        town.getName(),
                        town.getPopulation()))
                        .append(System.lineSeparator());
            }
        }

        return sb.toString().trim();
    }
}
