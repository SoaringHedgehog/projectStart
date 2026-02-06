package service;

import repository.TaskRepository;

import java.time.LocalDate;

public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(){
        this.taskRepository = new TaskRepository();
    }

    public void create(String task){
        int id = 0;
        String[] taskArr = task.split(" ");
        taskRepository.create(id, taskArr[0], taskArr[1], LocalDate.parse(taskArr[2]), LocalDate.parse(taskArr[3]));
    }

    public void read(String taskName){
        taskRepository.read(taskName);
    }

    public void update(String taskName){
        taskRepository.update(taskName);
    }

    public void delete(String taskName){
        taskRepository.delete(taskName);
    }
}
