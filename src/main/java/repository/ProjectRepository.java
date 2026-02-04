package repository;

import entity.Project;
import entity.Task;

import java.util.HashMap;
import java.util.Map;

public class ProjectRepository {
    //<name, project>
    private HashMap<String, Project> map;
    TaskRepository tr;

    public ProjectRepository(){
        this.map = new HashMap<>();
        this.tr = new TaskRepository();
    }

    //CREATE
    public void create(){
        Project project = new Project();
        map.put(project.getName(), project);
    }

    //READ
    public Project read(String projectName){
        return map.get(projectName);
    }

    public void findAll(){}
    public void findOne(){}

    //UPDATE
    public void update(String projectName){
        map.get(projectName);
    }

    //DELETE
    public void delete(String projectName){
        for(Task task : map.get(projectName).getTasks()){
            tr.delete(task.getName());
        }
        map.remove(projectName);
    }

    public void remove(){}
    public void removeAll(){}

    public void printTasks(Project project){
        for(Task task : project.getTasks()){
            System.out.println(task.toString());
        }
    }

    public void printAllProjects(){
        for(Map.Entry<String, Project> entry : map.entrySet()){
            String key = entry.getKey();
            Project project = entry.getValue();
            System.out.println("Ключ: " + key + "\nЗначение: " + project);
        }
    }

    public void persist(){}
    public void merge(){}
}
