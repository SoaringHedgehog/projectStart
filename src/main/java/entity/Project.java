package entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter @Setter
public class Project {
    private UUID id;
    private String name;
    private String description;
    private LocalDate dateStart;
    private LocalDate dateFinish;
    private List<Task> tasks;

    public Project(){
        this.tasks = new ArrayList<>();
    }
}
