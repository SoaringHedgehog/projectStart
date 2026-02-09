package service;

import entity.Project;
import entity.Task;
import repository.ProjectRepository;

import java.time.LocalDate;

public class ProjectService {
    private ProjectRepository projectRepository;
    private TaskService taskService;

    public ProjectService(TaskService taskService){
        this.projectRepository = new ProjectRepository();
        this.taskService = taskService;
    }

    //создание project в ProjectRepository
    public void create(String project){
        int id = 0;
        String[] taskArr = project.split(" ");
        projectRepository.create(id, taskArr[0], taskArr[1], LocalDate.parse(taskArr[2]), LocalDate.parse(taskArr[3]));
        //Конвертировать данные
        //+генерация id
    }


    //READ
    public Project findByName(String projectName){
        return projectRepository.findByName(projectName);
    }
    //TODO findById
    public Project findById(int projectName){
        return projectRepository.findById(projectName);
    }

    //UPDATE
    public void updateByName(String projectName){
        //Поле + новое значение
        projectRepository.updateByName(projectName);
    }

    public void updateById(int projectId){
        //Поле + новое значение
        projectRepository.updateById(projectId);
    }

    //DELETE
    public void deleteByName(String projectName){
        Project project = projectRepository.findByName(projectName);
        for(Task task : project.getTasks()){
            taskService.deleteByName(task.getName());
        }
        projectRepository.delete(projectName);
    }
}
