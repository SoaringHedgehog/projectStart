package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter @Setter
public class Project {
    private int id; //Потом замена типа на UUID
    private String name;
    private String description;
    private LocalDate dateStart;
    private LocalDate dateFinish;
    private List<Task> tasks;

    public Project(int id, String name, String description, LocalDate dateStart, LocalDate dateFinish){
        this.id = id;
        this.name = name;
        this.description = description;
        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
        this.tasks = new ArrayList<>();
    }
}
