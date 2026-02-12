package service;

import entity.Project;
import entity.Task;
import repository.ProjectRepository;
import repository.ProjectRepositoryImpl;

import java.time.LocalDate;

public class ProjectService {
    private ProjectRepository projectRepositoryImpl;
    private TaskService taskService;

    public ProjectService(TaskService taskService){
        this.projectRepositoryImpl = new ProjectRepositoryImpl();
        this.taskService = taskService;
    }

    //создание project в ProjectRepositoryImpl
    public void create(String project){
        int id = projectRepositoryImpl.getRepositorySize();
        String[] taskArr = project.split(" ");
        projectRepositoryImpl.create(id, taskArr[0], taskArr[1], LocalDate.parse(taskArr[2]), LocalDate.parse(taskArr[3]));
        //Конвертировать данные
        //+генерация id
    }


    //READ
    public Project findByName(String projectName){
        return projectRepositoryImpl.findByName(projectName);
    }
    public Project findById(int projectName){
        return projectRepositoryImpl.findById(projectName);
    }

    //UPDATE
    public void updateByName(String projectName){
        //Поле + новое значение
        projectRepositoryImpl.updateByName(projectName);
    }

    public void updateById(int projectId){
        //Поле + новое значение
        projectRepositoryImpl.updateById(projectId);
    }

    //DELETE
    public void deleteByName(String projectName){
        Project project = projectRepositoryImpl.findByName(projectName);
        for(Task task : project.getTasks()){
            taskService.deleteByName(task.getName());
        }
        projectRepositoryImpl.delete(projectName);
    }
}
