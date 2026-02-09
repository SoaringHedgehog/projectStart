package command;

import service.ProjectService;
import service.TaskService;

import java.util.HashMap;
import java.util.Scanner;

public class CommandRegistry {
    ProjectService projectService;
    TaskService taskService;
    HashMap<String, Command> commandMap;

    public CommandRegistry(Scanner scanner, ProjectService projectService, TaskService taskService){
        this.projectService = projectService;
        this.taskService = taskService;
        commandMap = new HashMap<>();

        Command command = new CreateProjectCommand(scanner, projectService);
        commandMap.put(command.getName(), command);
        command = new CreateTaskCommand(scanner, taskService);
        commandMap.put(command.getName(), command);
        command = new FindByNameProjectCommand(scanner, projectService);
        commandMap.put(command.getName(), command);
        command = new FindByNameProjectCommand(scanner, projectService);
        commandMap.put(command.getName(), command);
        command = new FindByNameTaskCommand(scanner, taskService);
        commandMap.put(command.getName(), command);
        command = new FindByIdProjectCommand(scanner, projectService);
        commandMap.put(command.getName(), command);
        command = new FindByIdTaskCommand(scanner, taskService);
        commandMap.put(command.getName(), command);
        command = new UpdateByNameProjectCommand(scanner, projectService);
        commandMap.put(command.getName(), command);
        command = new UpdateByNameTaskCommand(scanner, taskService);
        commandMap.put(command.getName(), command);
        command = new UpdateByIdProjectCommand(scanner, projectService);
        commandMap.put(command.getName(), command);
        command = new UpdateByIdTaskCommand(scanner, taskService);
        commandMap.put(command.getName(), command);
        command = new DeleteProjectCommand(scanner, projectService);
        commandMap.put(command.getName(), command);
        command = new DeleteTaskCommand(scanner, taskService);
        commandMap.put(command.getName(), command);
        command = new HelpCommand(commandMap);
        commandMap.put(command.getName(), command);
    }

    public Command getByName(String command){
        return commandMap.get(command);
    }
}
