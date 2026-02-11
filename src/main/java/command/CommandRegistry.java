package command;

import service.ProjectService;
import service.TaskService;

import java.util.HashMap;
import java.util.Scanner;

public class CommandRegistry {
    Scanner scanner;
    ProjectService projectService;
    TaskService taskService;
    HashMap<String, Command> commandMap;

    public CommandRegistry(Scanner scanner, ProjectService projectService, TaskService taskService){
        this.scanner = scanner;
        this.projectService = projectService;
        this.taskService = taskService;
        commandMap = new HashMap<>();
        init();
    }

    public Command getByName(String command){
        return commandMap.get(command);
    }

    public void init(){
        Command command = new ProjectCreateCommand(scanner, projectService);
        commandMap.put(command.getName(), command);
        command = new TaskCreateCommand(scanner, taskService);
        commandMap.put(command.getName(), command);
        command = new ProjectFindByNameCommand(scanner, projectService);
        commandMap.put(command.getName(), command);
        command = new ProjectFindByNameCommand(scanner, projectService);
        commandMap.put(command.getName(), command);
        command = new TaskFindByNameCommand(scanner, taskService);
        commandMap.put(command.getName(), command);
        command = new ProjectFindByIdCommand(scanner, projectService);
        commandMap.put(command.getName(), command);
        command = new TaskFindByIdCommand(scanner, taskService);
        commandMap.put(command.getName(), command);
        command = new ProjectUpdateByNameCommand(scanner, projectService);
        commandMap.put(command.getName(), command);
        command = new TaskUpdateByNameCommand(scanner, taskService);
        commandMap.put(command.getName(), command);
        command = new ProjectUpdateByIdCommand(scanner, projectService);
        commandMap.put(command.getName(), command);
        command = new TaskUpdateByIdCommand(scanner, taskService);
        commandMap.put(command.getName(), command);
        command = new ProjectDeleteCommand(scanner, projectService);
        commandMap.put(command.getName(), command);
        command = new TaskDeleteCommand(scanner, taskService);
        commandMap.put(command.getName(), command);
        command = new HelpCommand(commandMap);
        commandMap.put(command.getName(), command);
    }
}
