package repository;

import entity.Project;
import entity.Task;
import entity.User;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class ProjectRepositoryImpl implements ProjectRepository{
    //<name, project>
    private HashMap<String, Project> projectMap;

    public ProjectRepositoryImpl(){
        this.projectMap = new HashMap<>();
    }

    //CREATE
    public void create(int id, String name, String description, LocalDate dateStart, LocalDate dateFinish, int userId){
        if(!projectMap.containsKey(name)){
            Project project = new Project(id, name, description, dateStart, dateFinish, userId);
            projectMap.put(project.getName(), project);
            System.out.println("Проект успешно добавлен");
        }
        else{
            System.out.println("Проекта с таким названием уже существует. Попробуйте другое");
        }
    }

    //READ
    public Project findByName(String projectName){
        return projectMap.get(projectName);
    }
    public Project findById(int projectId){
        for(Map.Entry<String, Project> project : projectMap.entrySet()){
            if(project.getValue().getId() == projectId){
                return projectMap.get(project.getKey());
            }
        }
        return new Project();
    }

    //UPDATE
    public Project updateByName(String projectName){
        return projectMap.get(projectName);
    }
    public Project updateById(int projectId){
        for(Map.Entry<String, Project> project : projectMap.entrySet()){
            if(project.getValue().getId() == projectId){
                return projectMap.get(project.getKey());
            }
        }
        return new Project();
    }// TODO исправить

    //DELETE
    public void delete(String projectName){
        if(projectMap.containsKey(projectName)){
            projectMap.remove(projectName);
            System.out.println("Проект успешно удалён");
        }
        else{
            System.out.println("Проект с таким названием не найден.");
        }
    }

    public int getRepositorySize(){
        return projectMap.size();
    }

    public void printTasks(Project project){
        for(Task task : project.getTasks()){
            System.out.println(task.toString());
        }
    }

    public void printAllProjects(){
        for(Map.Entry<String, Project> entry : projectMap.entrySet()){
            String key = entry.getKey();
            Project project = entry.getValue();
            System.out.println("Ключ: " + key + "\nЗначение: " + project);
        }
    }
}