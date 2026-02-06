package entity;

import lombok.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter @Setter
public class Task {
    private int id; //Потом замена на UUID
    private String name;
    private String description;
    private LocalDate dateStart;
    private LocalDate dateFinish;
    private Project project;

    public Task(int id, String name, String description, LocalDate dateStart, LocalDate dateFinish){
        this.id = id;
        this.name = name;
        this.description = description;
        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
    }

    public String toString(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return "Id: " + id + ", Название: " + name + ", Описание: " + description
                + ", Дата начала: " + dtf.format(dateStart) + ", Дата окончания: " + dtf.format(dateFinish);
    }
}
