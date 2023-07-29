package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CarImportDto;
import softuni.exam.models.dto.CarsRootDto;
import softuni.exam.models.entity.Car;
import softuni.exam.repository.CarsRepository;
import softuni.exam.service.CarsService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


@Service
public class CarsServiceImpl implements CarsService {

    private static String CARS_FILE_PATH = "src/main/resources/files/xml/cars.xml";

    private final CarsRepository carsRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public CarsServiceImpl(CarsRepository carsRepository, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.carsRepository = carsRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return carsRepository.count() > 0;
    }

    @Override
    public String readCarsFromFile() throws IOException {
        return Files.readString(Path.of(CARS_FILE_PATH));
    }

    @Override
    public String importCars() throws IOException, JAXBException {
        StringBuilder builder = new StringBuilder();

        CarsRootDto carsRootDto = xmlParser.fromFile(CARS_FILE_PATH, CarsRootDto.class);
        List<CarImportDto> carImportDtoList = carsRootDto.getCars();

        for(CarImportDto carImportDto : carImportDtoList) {

            if(!validationUtil.isValid(carImportDto) || carsRepository.findByPlateNumber(carImportDto.getPlateNumber()) != null) {
                builder.append("Invalid car")
                        .append(System.lineSeparator());

            } else {
                Car car = modelMapper.map(carImportDto, Car.class);
                carsRepository.save(car);

                builder.append(String.format("Successfully imported car %s - %s",
                        car.getCarMake(),
                        car.getCarModel()))
                        .append(System.lineSeparator());

            }
        }

        return builder.toString().trim();
    }
}
