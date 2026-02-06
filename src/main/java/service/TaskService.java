package service;

import repository.TaskRepository;

import java.time.LocalDate;

public class TaskService {
    private TaskRepository tr;

    public TaskService(){
        this.tr = new TaskRepository();
    }

    public void create(String task){
        int id = 0;
        String[] taskArr = task.split(" ");
        tr.create(id, taskArr[0], taskArr[1], LocalDate.parse(taskArr[2]), LocalDate.parse(taskArr[3]));
    }

    public void read(String taskName){
        tr.read(taskName);
    }

    public void update(String taskName){
        tr.update(taskName);
    }

    public void delete(String taskName){
        tr.delete(taskName);
    }
}
