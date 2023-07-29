package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.TasksImportDto;
import softuni.exam.models.dto.TasksRootDto;
import softuni.exam.models.entity.Car;
import softuni.exam.models.entity.Mechanic;
import softuni.exam.models.entity.Part;
import softuni.exam.models.entity.Task;
import softuni.exam.repository.CarsRepository;
import softuni.exam.repository.MechanicsRepository;
import softuni.exam.repository.PartsRepository;
import softuni.exam.repository.TasksRepository;
import softuni.exam.service.TasksService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


@Service
public class TasksServiceImpl implements TasksService {
    private static String TASKS_FILE_PATH = "src/main/resources/files/xml/tasks.xml";

    private final TasksRepository tasksRepository;
    private final MechanicsRepository mechanicsRepository;
    private  final CarsRepository carsRepository;
    private final PartsRepository partsRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public TasksServiceImpl(TasksRepository tasksRepository, MechanicsRepository mechanicsRepository,
                            CarsRepository carsRepository, PartsRepository partsRepository, XmlParser xmlParser,
                            ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.tasksRepository = tasksRepository;
        this.mechanicsRepository = mechanicsRepository;
        this.carsRepository = carsRepository;
        this.partsRepository = partsRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return tasksRepository.count() > 0;
    }

    @Override
    public String readTasksFileContent() throws IOException {
        return Files.readString(Path.of(TASKS_FILE_PATH));
    }

    @Override
    public String importTasks() throws IOException, JAXBException {
        StringBuilder builder = new StringBuilder();

        TasksRootDto tasksRootDto = xmlParser.fromFile(TASKS_FILE_PATH, TasksRootDto.class);
        List<TasksImportDto> tasksImportDtoList = tasksRootDto.getTasks();

        for(TasksImportDto tasksImportDto : tasksImportDtoList) {

            if(!validationUtil.isValid(tasksImportDto) || mechanicsRepository.findByFirstName(tasksImportDto.getMechanic().getFirstName()) == null) {
                builder.append("Invalid task")
                        .append(System.lineSeparator());

            } else {
                Task task = modelMapper.map(tasksImportDto, Task.class);
                Mechanic mechanic = mechanicsRepository.findByFirstName(tasksImportDto.getMechanic().getFirstName());
                Car car = carsRepository.findById(tasksImportDto.getCar().getId()).get();
                Part part = partsRepository.findById(tasksImportDto.getPart().getId()).get();
                task.setMechanic(mechanic);
                task.setCar(car);
                task.setPart(part);
                tasksRepository.save(task);

                builder.append(String.format("Successfully imported task %.2f", task.getPrice()))
                        .append(System.lineSeparator());
            }
        }
        return builder.toString().trim();
    }

    @Override
    public String getCoupeCarTasksOrderByPrice() {
        StringBuilder builder = new StringBuilder();
        List<Task> taskList = tasksRepository.findAllByCarTypeCoupeOrderByPriceDesc();

        for(Task task : taskList) {
            builder.append(String.format("Car %s %s with %dkm\n" +
                            "-Mechanic: %s %s - task №%d:\n" +
                            " --Engine: %.1f\n" +
                            "---Price: %.2f$\n",
                            task.getCar().getCarMake(),
                            task.getCar().getCarModel(),
                            task.getCar().getKilometers(),
                            task.getMechanic().getFirstName(),
                            task.getMechanic().getLastName(),
                            task.getId(),
                            task.getCar().getEngine(),
                            task.getPrice()));
        }

        return builder.toString().trim();
    }
}
