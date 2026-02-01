package entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Task {
    private int id;
    private String name;
    private String description;
    private LocalDate dateStart;
    private LocalDate dateFinish;

    public Task(){

    }

    public String toString(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return "Id: " + id + ", Название: " + name + ", Описание: " + description
                + ", Дата начала: " + dtf.format(dateStart) + ", Дата окончания: " + dtf.format(dateFinish);
    }
}
