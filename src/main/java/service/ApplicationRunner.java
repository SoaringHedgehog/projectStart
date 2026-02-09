package service;

import command.Command;

import java.util.HashMap;

public class ApplicationRunner {
    private final ProjectService projectService;
    private final TaskService taskService;
    private final TerminalService terminalService;
    private FileServiceImpl fileService;
    private HashMap<String, Command> commandMap;

    public ApplicationRunner(){
        commandMap = new HashMap<>();

        taskService = new TaskService();
        projectService = new ProjectService(taskService);

        fileService = new FileServiceImpl(projectService, taskService);
        terminalService = new TerminalService(projectService, taskService, commandMap);
    }

    public void run(){
        //TODO  Заполнение сущностей из файлов(xls). Apache POI.
        //fileService.initialize();
        terminalService.start();
    }
}