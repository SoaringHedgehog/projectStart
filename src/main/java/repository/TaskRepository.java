package repository;

import entity.Project;
import entity.Task;

import java.time.LocalDate;
import java.util.HashMap;

public class TaskRepository {
    private HashMap<String, Task> map;

    public TaskRepository(){
        this.map = new HashMap<>();
    }

    public void create(int id, String name, String description, LocalDate dateStart, LocalDate dateFinish){
        Task task = new Task(id, name, description, dateStart, dateFinish);
        map.put(task.getName(), task);
    }

    public Task read(String taskName){
        return map.get(taskName);
    }

    public void update(String taskName){
        map.get(taskName);
    }

    public void delete(String taskName){
        //+Удалить из проекта, которому принадлежит задача
        map.remove(taskName);
    }

    public void printTask(String taskName){

    }

    public void findAll(){}
    public void findOne(){}
    public void persist(){}
    public void merge(){}
    public void remove(){}
    public void removeAll(){}
}
