package exam.service.impl;

import exam.model.dto.ShopsImportDto;
import exam.model.dto.ShopsRootDto;
import exam.model.entity.Shop;
import exam.model.entity.Town;
import exam.repository.ShopRepository;
import exam.repository.TownRepository;
import exam.service.ShopService;
import exam.util.ValidationUtil;
import exam.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    private static final String SHOPS_FILE_PATH = "src/main/resources/files/xml/shops.xml";
    private final ShopRepository shopRepository;
    private final TownRepository townRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private  final ValidationUtil validationUtil;

    public ShopServiceImpl(ShopRepository shopRepository, TownRepository townRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtil validationUtil) {
        this.shopRepository = shopRepository;
        this.townRepository = townRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
    }


    @Override
    public boolean areImported() {
        return shopRepository. count() > 0;
    }

    @Override
    public String readShopsFileContent() throws IOException {
        return Files.readString(Path.of(SHOPS_FILE_PATH));
    }

    @Override
    public String importShops() throws JAXBException, FileNotFoundException {
        StringBuilder out = new StringBuilder();

        ShopsRootDto shopsRootDto = xmlParser.fromFile(SHOPS_FILE_PATH, ShopsRootDto.class);
        List<ShopsImportDto> shopsImportDtoList = shopsRootDto.getShops();

        for (ShopsImportDto shopsImportDto : shopsImportDtoList) {

            if (!validationUtil.isValid(shopsImportDto) || shopRepository.findByName(shopsImportDto.getName()) != null) {
                out.append("Invalid shop")
                        .append(System.lineSeparator());

            } else {
                Shop shop = modelMapper.map(shopsImportDto, Shop.class);
                Town town = townRepository.findByName(shopsImportDto.getTown().getName());
                shop.setTown(town);
                shopRepository.save(shop);

                out.append(String.format("Successfully imported Shop %s - %.0f",
                        shop.getName(), shop.getIncome().doubleValue()))
                        .append(System.lineSeparator());
            }
        }
        return out.toString().trim();
    }
}
