package service;

import repository.ProjectRepository;

public class ProjectService {
    private ProjectRepository pr;

    public ProjectService(){
        this.pr = new ProjectRepository();
    }
    //создание project в ProjectRepository
    public void create(){
        pr.create();
        //Конвертировать данные
        //+генерация id
    }

    public void read(){

    }

    public void update(){

    }

    public void delete(){

    }
}
