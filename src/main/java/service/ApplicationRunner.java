package service;

public class ApplicationRunner {
    private final ProjectService projectService;
    private final TaskService taskService;
    private final TerminalService terminalService;
    private FileService fileService;
    // HashMap<String, Command> map

    public ApplicationRunner(){
        taskService = new TaskService();
        projectService = new ProjectService(taskService);
        terminalService = new TerminalService(projectService, taskService);
        // TODO Заполнить map всеми командами
    }

    public void run(){
        //TODO  Заполнение сущностей из файлов(xls). Apache POI.
        // +FileService
        // fileService.initialize();
        terminalService.start();
    }
}
