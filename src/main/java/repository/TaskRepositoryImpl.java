package repository;

import entity.Task;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class TaskRepositoryImpl implements TaskRepository{
    private HashMap<String, Task> tasksMap;

    public TaskRepositoryImpl(){
        this.tasksMap = new HashMap<>();
    }

    //CREATE
    @Override
    public void create(int id, String name, String description, LocalDate dateStart, LocalDate dateFinish){
        Task task = new Task(id, name, description, dateStart, dateFinish);
        tasksMap.put(task.getName(), task);
    }

    //READ
    @Override
    public Task findByName(String taskName){
        return tasksMap.get(taskName);
    }
    @Override
    public Task findById(int projectId){
        for(Map.Entry<String, Task> task : tasksMap.entrySet()){
            if(task.getValue().getId() == projectId){
                return tasksMap.get(task.getKey());
            }
        }
        return new Task();
    }

    //READ
    @Override
    public void updateByName(String taskName){
        tasksMap.get(taskName);
    }
    @Override
    public void updateById(int taskId){
        tasksMap.get(taskId);
    }

    //DELETE
    @Override
    public void deleteByName(String taskName){
        //+Удалить из проекта, которому принадлежит задача
        tasksMap.remove(taskName);
    }

    @Override
    public int getRepositorySize(){
        return tasksMap.size();
    }

    @Override
    public void printTask(String taskName){

    }
}
