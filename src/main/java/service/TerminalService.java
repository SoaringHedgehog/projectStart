package service;

import java.util.HashMap;
import java.util.Scanner;

public class TerminalService {
    private static final String HELP = "HELP";
    private static final String CREATE = "CREATE";
    private static final String READ = "READ";
    private static final String UPDATE = "UPDATE";
    private static final String DELETE = "DELETE";
    private static final String EXIT = "EXIT";

    private final ProjectService projectService;
    private final TaskService taskService;

    //TODO Map<Команда, класс команды> commandMap
    // +экземплярКласса get(commandName)
    // зарегистрировать команду = вставить в мапу

    Scanner scanner = new Scanner(System.in);

    public TerminalService(ProjectService projectService, TaskService taskService){
        this.taskService = taskService;
        this.projectService = projectService;
    }

    public void start(){
        boolean running = true;
        while(running){
            String command = scanner.next();
            String entity;
            switch(command){
                case HELP:
                    help();
                    break;
                case CREATE:
                    entity = scanner.next();
                    create(entity);
                    break;
                case READ:
                    entity = scanner.next();
                    read(entity);
                    break;
                case UPDATE:
                    entity = scanner.next();
                    update(entity);
                    break;
                case DELETE:
                    entity = scanner.next();
                    delete(entity);
                    break;
                case EXIT:
                    running = false;
                    break;
                default:
                    System.out.println("Такого варианта нет");
            }
        }
    }

    public void help(){
        System.out.println(CREATE + " Сущность");
        System.out.println(READ + " Сущность");
        System.out.println(UPDATE + " Сущность Название_Поля Значение");
        System.out.println(DELETE + " Сущность");
        System.out.println(EXIT);
        System.out.println();
    }

    public void create(String entity){
        if(entity.equalsIgnoreCase("Project")){
            System.out.println("Выбрано создание проекта");
            System.out.println("Введите через пробел имя, описание, дату начала и дату окончания проекта");
            String project = scanner.nextLine();
            projectService.create(project);
        }
        else if(entity.equalsIgnoreCase("Task")){
            System.out.println("Выбрано создание задачи");
            System.out.println("Введите через пробел имя, описание, дату начала и дату окончания проекта");
            String task = scanner.nextLine();
            taskService.create(task);
        }
        else{
            System.out.println("Такой сущности не существует");
        }
    }

    public void read(String entity){
        if(entity.equalsIgnoreCase("Project")){
            System.out.println("Выбрано чтение проекта");
            System.out.println("Введите имя проекта");
            String projectName = scanner.nextLine();
            projectService.readByName(projectName);
        }
        else if(entity.equalsIgnoreCase("Task")){
            System.out.println("Выбрано чтение задачи");
            System.out.println("Введите имя задачи");
            String taskName = scanner.nextLine();
            taskService.read(taskName);
        }
        else{
            System.out.println("Такой сущности не существует");
        }
    }

    public void update(String entity){
        if(entity.equalsIgnoreCase("Project")){
            System.out.println("Выбрано обновление проекта");
            System.out.println("Введите имя проекта");
            String projectName = scanner.nextLine();
            projectService.updateByName(projectName);
        }
        else if(entity.equalsIgnoreCase("Task")){
            System.out.println("Выбрано обновление задачи");
            System.out.println("Введите имя задачи");
            String taskName = scanner.nextLine();
            taskService.update(taskName);
        }
        else{
            System.out.println("Такой сущности не существует");
        }
    }

    public void delete(String entity){
        if(entity.equalsIgnoreCase("Project")){
            System.out.println("Выбрано удаление проекта");
            System.out.println("Введите имя проекта");
            String projectName = scanner.nextLine();
            projectService.deleteByName(projectName);
        }
        else if(entity.equalsIgnoreCase("Task")){
            System.out.println("Выбрано удаление задачи");
            System.out.println("Введите имя задачи");
            String taskName = scanner.nextLine();
            taskService.delete(taskName);
        }
        else{
            System.out.println("Такой сущности не существует");
        }
    }
}
