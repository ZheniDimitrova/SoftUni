package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.StarsImportDto;
import softuni.exam.models.entity.Constellation;
import softuni.exam.models.entity.Star;
import softuni.exam.repository.ConstellationRepository;
import softuni.exam.repository.StarRepository;
import softuni.exam.service.StarService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class StarServiceImpl implements StarService {
    private static final String STARS_FILE_PATH = "src/main/resources/files/json/stars.json";

    private final StarRepository starRepository;
    private final ConstellationRepository constellationRepository;

    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public StarServiceImpl(StarRepository starRepository, ConstellationRepository constellationRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.starRepository = starRepository;
        this.constellationRepository = constellationRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return starRepository.count() > 0;
    }

    @Override
    public String readStarsFileContent() throws IOException {
        return Files.readString(Path.of(STARS_FILE_PATH));
    }

    @Override
    public String importStars() throws IOException {
        StringBuilder out = new StringBuilder();
        StarsImportDto[] starsImportDtoS = gson.fromJson(readStarsFileContent(), StarsImportDto[].class);

        for (StarsImportDto starsImportDto : starsImportDtoS) {
            if (!validationUtil.isValid(starsImportDto) || starRepository.findByName(starsImportDto.getName()) != null) {
                out.append("Invalid star").append(System.lineSeparator());

            } else {
                Star star = modelMapper.map(starsImportDto, Star.class);
                Constellation constellation = constellationRepository.findById(starsImportDto.getConstellation()).get();
                star.setConstellation(constellation);

                starRepository.save(star);

                out.append(String.format("Successfully imported star %s - %.2f light years",
                        star.getName(),
                        star.getLightYears()))
                        .append(System.lineSeparator());
            }
        }

        return out.toString().trim();
    }

    @Override
    public String exportStars() {
        StringBuilder out = new StringBuilder();

        List<Star> starsList = starRepository.findTheNonObservedStars();

        for (Star star : starsList) {
            out.append(String.format("Star: %s\n" +
                    "   *Distance: %.2f light years\n" +
                    "   **Description: %s\n" +
                    "   ***Constellation: %s\n",
                    star.getName(),
                    star.getLightYears(),
                    star.getDescription(),
                    star.getConstellation().getName()));
        }
        return out.toString().trim();
    }
}
