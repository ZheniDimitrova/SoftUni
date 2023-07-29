package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
@XmlRootElement(name = "tasks")
@XmlAccessorType(XmlAccessType.FIELD)
public class TasksRootDto {
    @XmlElement(name = "task")
    List<TasksImportDto> tasks;

    public List<TasksImportDto> getTasks() {
        return tasks;
    }

    public void setTasks(List<TasksImportDto> tasks) {
        this.tasks = tasks;
    }
}
