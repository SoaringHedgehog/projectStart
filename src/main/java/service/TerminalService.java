package service;

import command.*;

import java.util.HashMap;
import java.util.Scanner;

public class TerminalService {
    private static final String HELP = "HELP";
    private static final String CREATE = "CREATE";
    private static final String READ = "READ";
    private static final String UPDATE = "UPDATE";
    private static final String DELETE = "DELETE";
    private static final String EXIT = "EXIT";

    Scanner scanner = new Scanner(System.in);
    private final ProjectService projectService;
    private final TaskService taskService;
    HashMap<String, Command> commandMap;

    //TODO Map<Команда, класс команды> commandMap
    // +экземплярКласса get(commandName)
    // зарегистрировать команду = вставить в мапу

    public TerminalService(ProjectService projectService, TaskService taskService, HashMap<String, Command> map){
        this.taskService = taskService;
        this.projectService = projectService;
        this.commandMap = map;

        commandMap.put("create project", new CreateProjectCommand(scanner, projectService));
        commandMap.put("create task", new CreateTaskCommand(scanner, taskService));
        commandMap.put("findbyname project", new FindByNameProjectCommand(scanner, projectService));
        commandMap.put("findbyname task", new FindByNameTaskCommand(scanner, taskService));
        commandMap.put("findbyid project", new FindByIdProjectCommand(scanner, projectService));
        commandMap.put("findbyid task", new FindByIdTaskCommand(scanner, taskService));
        commandMap.put("updatebyname project", new UpdateByNameProjectCommand(scanner, projectService));
        commandMap.put("updatebyname task", new UpdateByNameTaskCommand(scanner, taskService));
        commandMap.put("updatebyid project", new UpdateByIdProjectCommand(scanner, projectService));
        commandMap.put("updatebyid task", new UpdateByIdTaskCommand(scanner, taskService));
        commandMap.put("deleteByName project", new DeleteProjectCommand(scanner, projectService));
        commandMap.put("deleteByName task", new DeleteTaskCommand(scanner, taskService));
        commandMap.put("help", new HelpCommand(commandMap));
    }

    public void start(){
        boolean running = true;
        while(running){
            System.out.println("Введите команду: ");
            String command = scanner.nextLine().toLowerCase();
            if(command.equals("exit")) break;
            try{
                commandMap.get(command).process();
            }
            catch (Exception e){
                System.out.println("Такой команды не существует. Вызовите команду 'help' для просмотра " +
                        "команд и их описания");
                System.out.println(e);
            }
        }
    }
}
