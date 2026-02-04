package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter @Setter
@NoArgsConstructor
public class Task {
    private int id;
    private String name;
    private String description;
    private LocalDate dateStart;
    private LocalDate dateFinish;
    private Project project;

    public String toString(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return "Id: " + id + ", Название: " + name + ", Описание: " + description
                + ", Дата начала: " + dtf.format(dateStart) + ", Дата окончания: " + dtf.format(dateFinish);
    }
}
