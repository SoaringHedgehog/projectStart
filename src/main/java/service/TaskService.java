package service;

import entity.Task;
import repository.TaskRepository;
import repository.TaskRepositoryImpl;

import java.time.LocalDate;

public class TaskService {
    private final TaskRepository taskRepositoryImpl;

    public TaskService(){
        this.taskRepositoryImpl = new TaskRepositoryImpl();
    }

    //CREATE
    public void create(String task){
        int id = taskRepositoryImpl.getRepositorySize();
        String[] taskArr = task.split(" ");
        taskRepositoryImpl.create(id, taskArr[0], taskArr[1], LocalDate.parse(taskArr[2]), LocalDate.parse(taskArr[3]));
    }

    //READ
    public Task findByName(String taskName){
        return taskRepositoryImpl.findByName(taskName);
    }
    public Task findById(int taskId){
        return taskRepositoryImpl.findById(taskId);
    }

    //UPDATE
    public void updateByName(String taskName){
        taskRepositoryImpl.updateByName(taskName);
    }
    public void updateById(int taskId){
        taskRepositoryImpl.updateById(taskId);
    }

    //DELETE
    public void deleteByName(String taskName){
        taskRepositoryImpl.deleteByName(taskName);
    }
}
