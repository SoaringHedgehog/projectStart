package service;

import entity.Task;
import repository.TaskRepository;
import repository.TaskRepositoryImpl;

import java.time.LocalDate;

public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(){
        this.taskRepository = new TaskRepositoryImpl();
    }

    //CREATE
    public void create(String id, String name, String description, String dateStart, String dateFinish){
        Integer idChecked;
        if(id == null) idChecked = taskRepository.getRepositorySize();
        else idChecked = Integer.parseInt(id);

        if(name == null || name.isEmpty()){
            System.out.println("Имя проекта не может быть пустым");
            return;
        }
        if(dateStart == null || dateStart.isEmpty()){
            System.out.println("Дата начала не может быть пустой");
            return;
        }
        if(dateFinish == null || dateFinish.isEmpty()){
            System.out.println("Дата окончания не может быть пустой");
            return;
        }

        taskRepository.create(idChecked, name, description, LocalDate.parse(dateStart), LocalDate.parse(dateFinish));
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
