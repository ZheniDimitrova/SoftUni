package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.AgentImportDto;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.AgentService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


@Service
public class AgentServiceImpl implements AgentService {
    private static final String AGENT_PATH_FILE = "src/main/resources/files/json/agents.json";
    private final AgentRepository agentRepository;
    private final TownRepository townRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public AgentServiceImpl(AgentRepository agentRepository, TownRepository townRepository, Gson gson,
                            ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.agentRepository = agentRepository;
        this.townRepository = townRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {

        return agentRepository.count() > 0;
    }

    @Override
    public String readAgentsFromFile() throws IOException {
        return Files.readString(Path.of(AGENT_PATH_FILE));
    }

    @Override
    public String importAgents() throws IOException {
        StringBuilder builder = new StringBuilder();

        AgentImportDto[] agentImportDtoS = gson.fromJson(readAgentsFromFile(), AgentImportDto[].class);

        for(AgentImportDto agentImportDto : agentImportDtoS) {

            if (!validationUtil.isValid(agentImportDto) || agentRepository.findByFirstName(agentImportDto.getFirstName()) != null) {
                builder.append("Invalid agent").append(System.lineSeparator());
            } else {
                Agent agent = modelMapper.map(agentImportDto, Agent.class);
                Town town = townRepository.findByTownName(agentImportDto.getTown());
                agent.setTown(town);
                agentRepository.save(agent);

                builder.append(String.format("Successfully imported agent - %s %s",
                                agent.getFirstName(),
                                agent.getLastName()))
                        .append(System.lineSeparator());
            }
        }

        return builder.toString().trim();
    }
}
