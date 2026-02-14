package repository;

import entity.Project;
import entity.Task;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class TaskRepositoryImpl implements TaskRepository{
    private HashMap<String, Task> taskMap;

    public TaskRepositoryImpl(){
        this.taskMap = new HashMap<>();
    }

    //CREATE
    @Override
    public void create(int id, String name, String description, LocalDate dateStart, LocalDate dateFinish){
        if(!taskMap.containsKey(name)){
            Task task = new Task(id, name, description, dateStart, dateFinish);
            taskMap.put(task.getName(), task);
            System.out.println("Задача успешно добавлена");
        }
        else{
            System.out.println("Задача с таким названием уже существует. Попробуйте другое");
        }
    }

    //READ
    @Override
    public Task findByName(String taskName){
        return taskMap.get(taskName);
    }
    @Override
    public Task findById(int projectId){
        for(Map.Entry<String, Task> task : taskMap.entrySet()){
            if(task.getValue().getId() == projectId){
                return taskMap.get(task.getKey());
            }
        }
        return new Task();
    }

    //READ
    @Override
    public void updateByName(String taskName){
        taskMap.get(taskName);
    }
    @Override
    public void updateById(int taskId){
        taskMap.get(taskId);
    }

    //DELETE
    @Override
    public void deleteByName(String taskName){
        //+Удалить из проекта, которому принадлежит задача
        taskMap.remove(taskName);
    }

    @Override
    public int getRepositorySize(){
        return taskMap.size();
    }

    @Override
    public void printTask(String taskName){

    }
}
