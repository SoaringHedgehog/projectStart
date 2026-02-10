package repository;

import entity.Task;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class TaskRepository {
    private HashMap<String, Task> tasksMap;

    public TaskRepository(){
        this.tasksMap = new HashMap<>();
    }

    //CREATE
    public void create(int id, String name, String description, LocalDate dateStart, LocalDate dateFinish){
        Task task = new Task(id, name, description, dateStart, dateFinish);
        tasksMap.put(task.getName(), task);
    }

    //READ
    public Task findByName(String taskName){
        return tasksMap.get(taskName);
    }
    public Task findById(int projectId){
        for(Map.Entry<String, Task> task : tasksMap.entrySet()){
            if(task.getValue().getId() == projectId){
                return tasksMap.get(task.getKey());
            }
        }
        return new Task();
    }

    //READ
    public void updateByName(String taskName){
        tasksMap.get(taskName);
    }
    public void updateById(int taskId){
        tasksMap.get(taskId);
    }

    //DELETE
    public void deleteByName(String taskName){
        //+Удалить из проекта, которому принадлежит задача
        tasksMap.remove(taskName);
    }

    public int getSize(){
        return tasksMap.size();
    }

    public void printTask(String taskName){

    }

    public void persist(){}
    public void merge(){}
}
