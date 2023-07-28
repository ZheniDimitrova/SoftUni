package com.example.football.service.impl;

import com.example.football.models.dto.PlayersImportDto;
import com.example.football.models.dto.PlayersRootDto;
import com.example.football.models.entity.Player;
import com.example.football.models.entity.Stat;
import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;
import com.example.football.repository.PlayerRepository;
import com.example.football.repository.StatRepository;
import com.example.football.repository.TeamRepository;
import com.example.football.repository.TownRepository;
import com.example.football.service.PlayerService;
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
public class PlayerServiceImpl implements PlayerService {
    private static final String PLAYERS_FILE_PATH = "src/main/resources/files/xml/players.xml";
    private final PlayerRepository playerRepository;
    private final TownRepository townRepository;
    private final TeamRepository teamRepository;

    private final StatRepository statRepository;

    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;


    public PlayerServiceImpl(PlayerRepository playerRepository, TownRepository townRepository, TeamRepository teamRepository,
                             StatRepository statRepository, ModelMapper modelMapper, XmlParser xmlParser,
                             ValidationUtil validationUtil) {
        this.playerRepository = playerRepository;
        this.townRepository = townRepository;
        this.teamRepository = teamRepository;
        this.statRepository = statRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
    }


    @Override
    public boolean areImported() {
        return playerRepository.count() > 0;
    }

    @Override
    public String readPlayersFileContent() throws IOException {
        return Files.readString(Path.of(PLAYERS_FILE_PATH));
    }

    @Override
    public String importPlayers() throws JAXBException {
        StringBuilder sb = new StringBuilder();
        PlayersRootDto playersRootDto = xmlParser.fromFile(PLAYERS_FILE_PATH, PlayersRootDto.class);
        List<PlayersImportDto> playersImportDtoList = playersRootDto.getPlayers();

        for (PlayersImportDto playersImportDto : playersImportDtoList) {

            if (!validationUtil.isValid(playersImportDto) || playerRepository.findByEmail(playersImportDto.getEmail()) != null) {
                sb.append("Invalid Player").append(System.lineSeparator());

            } else {
                Player player = modelMapper.map(playersImportDto, Player.class);
                Town town = townRepository.findByName(playersImportDto.getTown().getName());
                Team team = teamRepository.findByName(playersImportDto.getTeam().getName());
                Stat stat = statRepository.findById(playersImportDto.getStat().getId()).get();
                player.setTown(town);
                player.setTeam(team);
                player.setStat(stat);

                playerRepository.save(player);

                sb.append(String.format("Successfully imported Player %s %s - %s",
                        player.getFirstName(),
                        player.getLastName(),
                        player.getPosition()))
                        .append(System.lineSeparator());
            }
        }

        return sb.toString().trim();
    }

    @Override
    public String exportBestPlayers() {
        StringBuilder sb = new StringBuilder();
        List<Player> exportPlayersList = playerRepository.findTheBestPlayers();

        for (Player player : exportPlayersList) {
            sb.append(String.format("Player - %s %s\n" +
                                     "\tPosition - %s\n" +
                                     "\tTeam - %s\n" +
                                     "\tStadium - %s\n",
                            player.getFirstName(),
                            player.getLastName(),
                            player.getPosition(),
                            player.getTeam().getName(),
                            player.getTeam().getStadiumName()));

        }
        return sb.toString().trim();
    }
}
