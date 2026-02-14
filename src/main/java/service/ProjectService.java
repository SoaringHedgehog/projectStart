package service;

import entity.Project;
import entity.Task;
import repository.ProjectRepository;
import repository.ProjectRepositoryImpl;

import java.time.LocalDate;

public class ProjectService {
    private ProjectRepository projectRepository;
    private TaskService taskService;
    private UserService userService;

    public ProjectService(TaskService taskService, UserService userService){
        this.projectRepository = new ProjectRepositoryImpl();
        this.taskService = taskService;
        this.userService = userService;
    }

    //создание project в ProjectRepositoryImpl
    public void create(String id, String name, String description, String dateStart, String dateFinish, String userId){
        Integer idChecked;
        if(id == null) idChecked = projectRepository.getRepositorySize();
        else idChecked = Integer.parseInt(id);

        if(name == null || name.isEmpty()){
            System.out.println("Имя проекта не может быть пустым");
            return;
        }
        if(dateStart == null || dateStart.isEmpty()){
            System.out.println("Дата начала не может быть пустой");
            return;
        }
        if(dateFinish == null || dateFinish.isEmpty()){
            System.out.println("Дата окончания не может быть пустой");
            return;
        }
        int userIdChecked;
        if(userId == null || userId.isEmpty()){
            System.out.println("Пользователь проекта не может быть пустой");
            return;
        }
        else{
            userIdChecked = Integer.parseInt(userId);
        }

        projectRepository.create(idChecked, name, description, LocalDate.parse(dateStart), LocalDate.parse(dateFinish), userIdChecked);
    }


    //READ
    public Project findByName(String projectName){
        return projectRepository.findByName(projectName);
    }
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
