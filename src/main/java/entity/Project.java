package entity;

import java.time.LocalDate;
import java.util.HashMap;

public class Project {
    private int id;
    private String name;
    private String description;
    private LocalDate dateStart;
    private LocalDate dateFinish;
    HashMap<String, Task> tasks;

    public Project(){
        this.tasks = new HashMap<>();
    }

    public void create(){

    }

    public void read(){

    }

    public void update(){

    }

    public void delete(){

    }

    public void printTasks(){
        for(int i = 0; i < tasks.size(); i++){
            System.out.println(tasks.get(i).toString());
        }
    }
}
