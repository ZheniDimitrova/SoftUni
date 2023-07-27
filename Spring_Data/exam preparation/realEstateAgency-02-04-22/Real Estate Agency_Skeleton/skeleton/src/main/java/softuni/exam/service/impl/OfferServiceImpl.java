package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.OfferImportDto;
import softuni.exam.models.dto.OffersRootDto;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.Offer;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.OfferService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {
    private static final String OFFERS_FILE_PATH = "src/main/resources/files/xml/offers.xml";
    private final OfferRepository offerRepository;
    private final AgentRepository agentRepository;
    private final ApartmentRepository apartmentRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;


    public OfferServiceImpl(OfferRepository offerRepository, AgentRepository agentRepository, ApartmentRepository apartmentRepository, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser) {
        this.offerRepository = offerRepository;
        this.agentRepository = agentRepository;
        this.apartmentRepository = apartmentRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return offerRepository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return Files.readString(Path.of(OFFERS_FILE_PATH));
    }

    @Override
    public String importOffers() throws IOException, JAXBException {
        StringBuilder builder = new StringBuilder();

        OffersRootDto offersRootDto = xmlParser.fromFile(OFFERS_FILE_PATH, OffersRootDto.class);
        List<OfferImportDto> offersList = offersRootDto.getOffers();

        for(OfferImportDto offerImportDto : offersList) {

            if(!validationUtil.isValid(offerImportDto) || agentRepository.findByFirstName(offerImportDto.getAgent().getName()) == null) {
                builder.append("Invalid offer")
                        .append(System.lineSeparator());

            } else {
                Offer offer = modelMapper.map(offerImportDto, Offer.class);
                Apartment apartment = apartmentRepository.findById(offerImportDto.getApartment().getId()).get();
                Agent agent = agentRepository.findByFirstName(offerImportDto.getAgent().getName());
                offer.setApartment(apartment);
                offer.setAgent(agent);
                offerRepository.save(offer);

                builder.append(String.format("Successfully imported offer %.2f", offer.getPrice()))
                        .append(System.lineSeparator());

            }

        }


        return builder.toString().trim();
    }

    @Override
    public String exportOffers() {
        StringBuilder builder = new StringBuilder();

        List<Offer> offers = offerRepository.findOrderedOffers();

        for(Offer offer : offers) {
            builder.append(String.format("Agent %s %s with offer №%d:\n" +
                    "   \t\t-Apartment area: %.2f\n" +
                    "   \t\t--Town: %s\n" +
                    "   \t\t---Price: %.2f$\n",
                    offer.getAgent().getFirstName(),
                    offer.getAgent().getLastName(),
                    offer.getId(),
                    offer.getApartment().getArea(),
                    offer.getAgent().getTown().getTownName(),
                    offer.getPrice()));
        }

        return builder.toString().trim();
    }
}
