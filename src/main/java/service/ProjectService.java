package service;

import repository.ProjectRepository;

import java.time.LocalDate;

public class ProjectService {
    private ProjectRepository pr;

    public ProjectService(){
        this.pr = new ProjectRepository();
    }
    //создание project в ProjectRepository
    public void create(String project){
        int id = 0;
        String[] taskArr = project.split(" ");
        pr.create(id, taskArr[0], taskArr[1], LocalDate.parse(taskArr[2]), LocalDate.parse(taskArr[3]));
        //Конвертировать данные
        //+генерация id
    }

    public void read(String projectName){
        pr.read(projectName);
    }

    public void update(String projectName){
        pr.update(projectName);
    }

    public void delete(String projectName){
        pr.delete(projectName);
    }
}
