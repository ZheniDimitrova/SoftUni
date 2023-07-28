package exam.service.impl;

import com.google.gson.Gson;
import exam.model.dto.LaptopsImportDto;
import exam.model.entity.Laptop;
import exam.model.entity.Shop;
import exam.repository.LaptopRepository;
import exam.repository.ShopRepository;
import exam.service.LaptopService;
import exam.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class LaptopServiceImpl implements LaptopService {
    private static final String LAPTOPS_FILE_PATH = "src/main/resources/files/json/laptops.json";

    private final LaptopRepository laptopRepository;
    private final ShopRepository shopRepository;

    private final Gson gson;

    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public LaptopServiceImpl(LaptopRepository laptopRepository, ShopRepository shopRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.laptopRepository = laptopRepository;
        this.shopRepository = shopRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return laptopRepository.count() > 0;
    }

    @Override
    public String readLaptopsFileContent() throws IOException {
        return Files.readString(Path.of(LAPTOPS_FILE_PATH));
    }

    @Override
    public String importLaptops() throws IOException {
        StringBuilder out = new StringBuilder();

        LaptopsImportDto[] laptopsImportDtoS = gson.fromJson(readLaptopsFileContent(), LaptopsImportDto[].class);

        for (LaptopsImportDto laptopsImportDto : laptopsImportDtoS) {

            if (!validationUtil.isValid(laptopsImportDto) || laptopRepository.findByMacAddress(laptopsImportDto.getMacAddress()) != null) {
                out.append("Invalid Laptop").append(System.lineSeparator());

            } else {
                Laptop laptop = modelMapper.map(laptopsImportDto, Laptop.class);
                Shop shop = shopRepository.findByName(laptopsImportDto.getShop().getName());
                laptop.setShop(shop);
                laptopRepository.save(laptop);

                out.append(String.format("Successfully imported Laptop %s - %.2f - %d - %d",
                        laptop.getMacAddress(),
                        laptop.getCpuSpeed(),
                        laptop.getRam(),
                        laptop.getStorage()))
                        .append(System.lineSeparator());
            }
        }

        return out.toString().trim();
    }

    @Override
    public String exportBestLaptops() {
        StringBuilder out = new StringBuilder();
        List<Laptop> laptopList = laptopRepository.findBestLaptops();

        for (Laptop laptop : laptopList) {
            out.append(String.format("Laptop - %s\n" +
                    "*Cpu speed - %.2f\n" +
                    "**Ram - %d\n" +
                    "***Storage - %d\n" +
                    "****Price - %.2f\n" +
                    "#Shop name - %s\n" +
                    "##Town - %s\n",
                    laptop.getMacAddress(),
                    laptop.getCpuSpeed(),
                    laptop.getRam(),
                    laptop.getStorage(),
                    laptop.getPrice(),
                    laptop.getShop().getName(),
                    laptop.getShop().getTown().getName()))
                    .append(System.lineSeparator());
        }

        return out.toString().trim();
    }
}
