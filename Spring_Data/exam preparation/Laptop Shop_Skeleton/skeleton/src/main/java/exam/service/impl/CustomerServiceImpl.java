package exam.service.impl;

import com.google.gson.Gson;
import exam.model.dto.CustomersImportDto;
import exam.model.entity.Customer;
import exam.model.entity.Town;
import exam.repository.CustomerRepository;
import exam.repository.TownRepository;
import exam.service.CustomerService;
import exam.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


@Service
public class CustomerServiceImpl implements CustomerService {

    private static final String CUSTOMERS_FILE_PATH = "src/main/resources/files/json/customers.json";

   private final CustomerRepository customerRepository;
   private final TownRepository townRepository;
   private final Gson gson;

   private final ModelMapper modelMapper;
   private final ValidationUtil validationUtil;

    public CustomerServiceImpl(CustomerRepository customerRepository, TownRepository townRepository, Gson gson,
                               ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.customerRepository = customerRepository;
        this.townRepository = townRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return customerRepository.count() > 0;
    }

    @Override
    public String readCustomersFileContent() throws IOException {
        return Files.readString(Path.of(CUSTOMERS_FILE_PATH));
    }

    @Override
    public String importCustomers() throws IOException {
        StringBuilder out = new StringBuilder();

        CustomersImportDto[] customersImportDtoS = gson.fromJson(readCustomersFileContent(), CustomersImportDto[].class);
        for (CustomersImportDto customersImportDto : customersImportDtoS) {

            if (!validationUtil.isValid(customersImportDto) || customerRepository.findByEmail(customersImportDto.getEmail()) != null) {
                out.append("Invalid Customer").append(System.lineSeparator());

            } else {
                Customer customer = modelMapper.map(customersImportDto, Customer.class);
                Town town = townRepository.findByName(customersImportDto.getTown().getName());
                customer.setTown(town);

                customerRepository.save(customer);

                out.append(String.format("Successfully imported Customer %s %s - %s",
                        customer.getFirstName(),
                        customer.getLastName(),
                        customer.getEmail()))
                        .append(System.lineSeparator());

            }
        }
        return out.toString().trim();
    }
}
