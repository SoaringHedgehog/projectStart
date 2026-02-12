package service;

import command.*;
import command.CommandRegistry;
import entity.User;

import java.util.HashMap;
import java.util.Scanner;

public class TerminalService implements ServiceLocator{
    private static final String HELP = "HELP";
    private static final String CREATE = "CREATE";
    private static final String READ = "READ";
    private static final String UPDATE = "UPDATE";
    private static final String DELETE = "DELETE";
    private static final String EXIT = "EXIT";

    Scanner scanner = new Scanner(System.in);
    private final ProjectService projectService;
    private final TaskService taskService;
    private final UserService userService;
    private final CommandRegistry commandRegistry;
    private User currentUser;

    public TerminalService(ProjectService projectService, TaskService taskService, UserService userService, HashMap<String, Command> map){
        this.taskService = taskService;
        this.projectService = projectService;
        this.userService = userService;
        this.commandRegistry = new CommandRegistry(scanner, projectService, taskService, userService, currentUser);
    }

    // TODO 4.3.3
    public void start(){
        boolean running = true;
        while(running){
            System.out.println("Введите команду: ");
            try{
                Command command = commandRegistry.getByName(scanner.nextLine().toLowerCase());

                if (command != null && command.getClass().isAnnotationPresent(RequiresAuth.class) && currentUser == null) {
                    System.out.println("Для этой команды необходимо войти в систему.");
                }
                else if(command == null) continue;
                else{
                    command.process();
                }
            }
            catch (Exception e){
                System.out.println("Такой команды не существует. Вызовите команду 'help' для просмотра " +
                        "команд и их описания");
                System.out.println(e);
            }
        }
    }
}
