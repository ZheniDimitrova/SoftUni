package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ApartmentImportDto;
import softuni.exam.models.dto.ApartmentsRootDto;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.ApartmentService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class ApartmentServiceImpl implements ApartmentService {

    private static final String APARTMENTS_FILE_PATH = "src/main/resources/files/xml/apartments.xml";

    private final ApartmentRepository apartmentRepository;
    private final TownRepository townRepository;

    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;


    public ApartmentServiceImpl(ApartmentRepository apartmentRepository, TownRepository townRepository, ModelMapper modelMapper,
                                ValidationUtil validationUtil, XmlParser xmlParser) {
        this.apartmentRepository = apartmentRepository;
        this.townRepository = townRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {

        return apartmentRepository.count() > 0;
    }

    @Override
    public String readApartmentsFromFile() throws IOException {
        return Files.readString(Path.of(APARTMENTS_FILE_PATH));
    }

    @Override
    public String importApartments() throws IOException, JAXBException {
        StringBuilder builder = new StringBuilder();

        ApartmentsRootDto apartmentsRootDto = xmlParser.fromFile(APARTMENTS_FILE_PATH, ApartmentsRootDto.class);

        List<ApartmentImportDto> apartmentsList = apartmentsRootDto.getApartments();

        for (ApartmentImportDto apartmentImportDto : apartmentsList) {

            if(!validationUtil.isValid(apartmentImportDto)
                    || apartmentRepository.findByTownNameAndArea(apartmentImportDto.getTown(), apartmentImportDto.getArea()) != null) {
            builder.append("Invalid apartment").append(System.lineSeparator());

            } else {
                Apartment apartment = modelMapper.map(apartmentImportDto, Apartment.class);
                Town town = townRepository.findByTownName(apartmentImportDto.getTown());
                apartment.setTown(town);
                apartmentRepository.save(apartment);

                builder.append(String.format("Successfully imported apartment %s - %.2f",
                            apartment.getApartmentType(),
                            apartment.getArea()))
                        .append(System.lineSeparator());

            }

        }
        return builder.toString().trim();
    }
}
