package repository;

import entity.Project;
import entity.Task;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class ProjectRepository {
    //<name, project>
    private HashMap<String, Project> projectsMap;

    public ProjectRepository(){
        this.projectsMap = new HashMap<>();
    }

    //CREATE
    public void create(int id, String name, String description, LocalDate dateStart, LocalDate dateFinish){
        Project project = new Project(id, name, description, dateStart, dateFinish);
        projectsMap.put(project.getName(), project);
    }

    //READ
    public Project findByName(String projectName){
        return projectsMap.get(projectName);
    }
    public Project findById(int projectId){
        for(Map.Entry<String, Project> project : projectsMap.entrySet()){
            if(project.getValue().getId() == projectId){
                return projectsMap.get(project.getKey());
            }
        }
        return new Project();
    }

    //UPDATE
    public Project updateByName(String projectName){
        return projectsMap.get(projectName);
    }
    public Project updateById(int projectId){
        for(Map.Entry<String, Project> project : projectsMap.entrySet()){
            if(project.getValue().getId() == projectId){
                return projectsMap.get(project.getKey());
            }
        }
        return new Project();
    }// TODO исправить

    //DELETE
    public void delete(String projectName){
        projectsMap.remove(projectName);
    }

    public int getSize(){
        return projectsMap.size();
    }

    public void printTasks(Project project){
        for(Task task : project.getTasks()){
            System.out.println(task.toString());
        }
    }

    public void printAllProjects(){
        for(Map.Entry<String, Project> entry : projectsMap.entrySet()){
            String key = entry.getKey();
            Project project = entry.getValue();
            System.out.println("Ключ: " + key + "\nЗначение: " + project);
        }
    }

    public void persist(){}
    public void merge(){}
}
