package softuni.exam;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.exam.service.AgentService;
import softuni.exam.service.ApartmentService;
import softuni.exam.service.OfferService;
import softuni.exam.service.TownService;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner  {

    private final TownService townService;
    private final AgentService agentService;
    private final ApartmentService apartmentService;

    private final OfferService offerService;

    public CommandLineRunnerImpl(TownService townService, AgentService agentService, ApartmentService apartmentService, OfferService offerService) {
        this.townService = townService;
        this.agentService = agentService;
        this.apartmentService = apartmentService;
        this.offerService = offerService;
    }

    @Override
    public void run(String... args) throws Exception {

        if(!townService.areImported()){
            System.out.println(townService.importTowns());
        }

        if(!agentService.areImported()) {
            System.out.println(agentService.importAgents());
        }
        if(!apartmentService.areImported()) {
            System.out.println(apartmentService.importApartments());
        }
        if(!offerService.areImported()) {
            System.out.println(offerService.importOffers());
        }

        System.out.println(offerService.exportOffers());


    }
}
