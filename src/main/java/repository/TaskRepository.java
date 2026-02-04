package repository;

import entity.Project;
import entity.Task;

import java.util.HashMap;

public class TaskRepository {
    private HashMap<String, Task> map;

    public TaskRepository(){
        this.map = new HashMap<>();
    }

    public void create(){
        Task task = new Task();
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
