package service;

import command.Command;

import java.util.HashMap;

public class ApplicationRunner {
    private final ProjectService projectService;
    private final TaskService taskService;
    private final TerminalService terminalService;
    private FileService fileService;
    private HashMap<String, Command> commandMap;

    public ApplicationRunner(){
        taskService = new TaskService();
        projectService = new ProjectService(taskService);
        commandMap = new HashMap<>();
        terminalService = new TerminalService(projectService, taskService, commandMap);
        // TODO Заполнить map всеми командами
    }

    public void run(){
        //TODO  Заполнение сущностей из файлов(xls). Apache POI.
        // +FileService
        // fileService.initialize();
        fileService.initialize();
        terminalService.start();
    }
}
