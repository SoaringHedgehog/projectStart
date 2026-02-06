package service;

import java.util.Scanner;

public class TerminalService {
    public static final String HELP = "HELP";
    public static final String CREATE = "CREATE";
    public static final String READ = "READ";
    public static final String UPDATE = "UPDATE";
    public static final String DELETE = "DELETE";
    public static final String EXIT = "EXIT";

    Scanner sc = new Scanner(System.in);

    ProjectService ps;
    TaskService ts;

    public TerminalService(){
        this.ps = new ProjectService();
        this.ts = new TaskService();
    }

    public void start(){
        boolean running = true;
        while(running){
            String command = sc.next();
            String entity;
            switch(command){
                case HELP:
                    help();
                    break;
                case CREATE:
                    entity = sc.next();
                    create(entity);
                    break;
                case READ:
                    entity = sc.next();
                    read(entity);
                    break;
                case UPDATE:
                    entity = sc.next();
                    update(entity);
                    break;
                case DELETE:
                    entity = sc.next();
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
        System.out.println(UPDATE + " Сущность");
        System.out.println(DELETE + " Сущность");
        System.out.println(EXIT);
        System.out.println();
    }

    public void create(String entity){
        if(entity.equalsIgnoreCase("Project")){
            System.out.println("Выбрано создание проекта");
            System.out.println("Введите через пробел имя, описание, дату начала и дату окончания проекта");
            String project = sc.nextLine();
            ps.create(project);
        }
        else if(entity.equalsIgnoreCase("Task")){
            System.out.println("Выбрано создание задачи");
            System.out.println("Введите через пробел имя, описание, дату начала и дату окончания проекта");
            String task = sc.nextLine();
            ts.create(task);
        }
        else{
            System.out.println("Такой сущности не существует");
        }
    }

    public void read(String entity){
        if(entity.equalsIgnoreCase("Project")){
            System.out.println("Выбрано чтение проекта");
            System.out.println("Введите имя проекта");
            String projectName = sc.nextLine();
            ps.read(projectName);
        }
        else if(entity.equalsIgnoreCase("Task")){
            System.out.println("Выбрано чтение задачи");
            System.out.println("Введите имя задачи");
            String taskName = sc.nextLine();
            ts.read(taskName);
        }
        else{
            System.out.println("Такой сущности не существует");
        }
    }

    public void update(String entity){
        if(entity.equalsIgnoreCase("Project")){
            System.out.println("Выбрано обновление проекта");
            System.out.println("Введите имя проекта");
            String projectName = sc.nextLine();
            ps.update(projectName);
        }
        else if(entity.equalsIgnoreCase("Task")){
            System.out.println("Выбрано обновление задачи");
            System.out.println("Введите имя задачи");
            String taskName = sc.nextLine();
            ts.update(taskName);
        }
        else{
            System.out.println("Такой сущности не существует");
        }
    }

    public void delete(String entity){
        if(entity.equalsIgnoreCase("Project")){
            System.out.println("Выбрано удаление проекта");
            System.out.println("Введите имя проекта");
            String projectName = sc.nextLine();
            ps.delete(projectName);
        }
        else if(entity.equalsIgnoreCase("Task")){
            System.out.println("Выбрано удаление задачи");
            System.out.println("Введите имя задачи");
            String taskName = sc.nextLine();
            ts.delete(taskName);
        }
        else{
            System.out.println("Такой сущности не существует");
        }
    }
}
