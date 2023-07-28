package com.example.football.service.impl;

import com.example.football.models.dto.TeamsImportDto;
import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;
import com.example.football.repository.TeamRepository;
import com.example.football.repository.TownRepository;
import com.example.football.service.TeamService;
import com.example.football.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class TeamServiceImpl implements TeamService {
    private static final String TEAMS_FILE_PATH = "src/main/resources/files/json/teams.json";

    private final TeamRepository teamRepository;
    private final TownRepository townRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    public TeamServiceImpl(TeamRepository teamRepository, TownRepository townRepository, ModelMapper modelMapper,
                           Gson gson, ValidationUtil validationUtil) {
        this.teamRepository = teamRepository;
        this.townRepository = townRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }



    @Override
    public boolean areImported() {
        return teamRepository.count() > 0;
    }

    @Override
    public String readTeamsFileContent() throws IOException {
        return Files.readString(Path.of(TEAMS_FILE_PATH));
    }

    @Override
    public String importTeams() throws IOException {
        StringBuilder sb = new StringBuilder();

        TeamsImportDto[] teamsImportDtoS = gson.fromJson(readTeamsFileContent(), TeamsImportDto[].class);

        for (TeamsImportDto teamsImportDto : teamsImportDtoS) {

            if(!validationUtil.isValid(teamsImportDto) || teamRepository.findByName(teamsImportDto.getName()) != null) {
                sb.append("Invalid Team")
                        .append(System.lineSeparator());

            } else {
                Team team = modelMapper.map(teamsImportDto, Team.class);
                Town town = townRepository.findByName(teamsImportDto.getTownName());
                team.setTown(town);
                teamRepository.save(team);

                sb.append(String.format("Successfully imported Team %s - %d",
                        team.getName(),
                        team.getFanBase()))
                        .append(System.lineSeparator());
            }
        }


        return sb.toString().trim();
    }
}
