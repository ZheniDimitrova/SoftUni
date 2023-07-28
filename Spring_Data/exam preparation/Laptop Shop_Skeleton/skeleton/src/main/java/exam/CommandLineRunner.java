package exam;

import exam.service.CustomerService;
import exam.service.LaptopService;
import exam.service.ShopService;
import exam.service.TownService;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {

    private final CustomerService customerService;
    private final LaptopService laptopService;
    private final ShopService shopService;
    private final TownService townService;

    public CommandLineRunner(CustomerService customerService, LaptopService laptopService, ShopService shopService, TownService townService) {
        this.customerService = customerService;
        this.laptopService = laptopService;
        this.shopService = shopService;
        this.townService = townService;
    }

    @Override
    public void run(String... args) throws Exception {

        if(!townService.areImported()) {
            System.out.println(townService.importTowns());
        }

        if(!shopService.areImported()){
            System.out.println(shopService.importShops());
        }

        if (!customerService.areImported()) {
            System.out.println(customerService.importCustomers());
        }

        if(!laptopService.areImported()) {
            System.out.println(laptopService.importLaptops());
        }

        System.out.println(laptopService.exportBestLaptops());

    }
}
