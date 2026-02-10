package service;

import entity.Task;
import repository.TaskRepository;

import java.time.LocalDate;

public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(){
        this.taskRepository = new TaskRepository();
    }

    //CREATE
    public void create(String task){
        int id = taskRepository.getSize();
        String[] taskArr = task.split(" ");
        taskRepository.create(id, taskArr[0], taskArr[1], LocalDate.parse(taskArr[2]), LocalDate.parse(taskArr[3]));
    }

    //READ
    public Task findByName(String taskName){
        return taskRepository.findByName(taskName);
    }
    public Task findById(int taskId){
        return taskRepository.findById(taskId);
    }

    //UPDATE
    public void updateByName(String taskName){
        taskRepository.updateByName(taskName);
    }
    public void updateById(int taskId){
        taskRepository.updateById(taskId);
    }

    //DELETE
    public void deleteByName(String taskName){
        taskRepository.deleteByName(taskName);
    }
}
