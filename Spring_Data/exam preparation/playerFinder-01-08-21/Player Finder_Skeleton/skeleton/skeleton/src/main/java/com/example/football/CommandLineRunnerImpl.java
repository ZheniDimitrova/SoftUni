package com.example.football;

import com.example.football.service.PlayerService;
import com.example.football.service.StatService;
import com.example.football.service.TeamService;
import com.example.football.service.TownService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final StatService statService;
    private final TeamService teamService;
    private final TownService townService;
    private final PlayerService playerService;

    public CommandLineRunnerImpl(StatService statService, TeamService teamService, TownService townService, PlayerService playerService) {
        this.statService = statService;
        this.teamService = teamService;
        this.townService = townService;
        this.playerService = playerService;
    }


    @Override
    public void run(String... args) throws Exception {

        if(!townService.areImported()) {
            System.out.println(townService.importTowns());
        }

        if(!teamService.areImported()) {
            System.out.println(teamService.importTeams());
        }
        if(!statService.areImported()) {
            System.out.println(statService.importStats());
        }

        System.out.println(playerService.exportBestPlayers());


    }
}
