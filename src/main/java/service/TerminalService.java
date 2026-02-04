package service;

import java.util.Scanner;

public class TerminalService {
    public static final String HELP = "HELP";
    public static final String CREATE = "CREATE";
    public static final String READ = "READ";
    public static final String UPDATE = "UPDATE";
    public static final String DELETE = "DELETE";
    public static final String EXIT = "EXIT";

    ProjectService ps;
    TaskService ts;

    public TerminalService(){
        this.ps = new ProjectService();
        this.ts = new TaskService();
    }

    public void start(){
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while(running){
            String command = sc.nextLine();
            switch(command){
                case HELP:
                    help();
                    break;
                case CREATE:
                    create();
                    break;
                case READ:
                    read();
                    break;
                case UPDATE:
                    update();
                    break;
                case DELETE:
                    delete();
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

    public void create(){
        ps.create();
    }

    public void read(){
        ps.read();
    }

    public void update(){
        ps.update();
    }

    public void delete(){
        ps.delete();
    }
}
