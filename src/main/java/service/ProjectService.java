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

    public Project readByName(String projectName){
        return projectRepository.read(projectName);
    }

    public void updateByName(String projectName){
        //Поле + новое значение
        projectRepository.update(projectName);
    }

    public void deleteByName(String projectName){
        Project project = projectRepository.read(projectName);
        for(Task task : project.getTasks()){
            taskService.delete(task.getName());
        }
        projectRepository.delete(projectName);
    }
}
