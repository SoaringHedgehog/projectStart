package service;

import command.*;
import command.CommandRegistry;

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
    CommandRegistry commandRegistry;

    //TODO Map<Команда, класс команды> commandMap
    // +экземплярКласса get(commandName)
    // зарегистрировать команду = вставить в мапу

    public TerminalService(ProjectService projectService, TaskService taskService, HashMap<String, Command> map){
        this.taskService = taskService;
        this.projectService = projectService;
        this.commandRegistry = new CommandRegistry(scanner, projectService, taskService);
    }

    public void start(){
        boolean running = true;
        while(running){
            System.out.println("Введите команду: ");
            String command = scanner.nextLine().toLowerCase();
            if(command.equals("exit")) break;
            try{
                commandRegistry.getByName(command).process();
            }
            catch (Exception e){
                System.out.println("Такой команды не существует. Вызовите команду 'help' для просмотра " +
                        "команд и их описания");
            }
        }
    }
}
