package command;

import service.ProjectService;

import java.util.Scanner;

public class DeleteProjectCommand implements Command{
    private final Scanner scanner;
    private final ProjectService projectService;
    String pattern = "deleteByName project";

    public DeleteProjectCommand(Scanner scanner, ProjectService projectService){
        this.scanner = scanner;
        this.projectService = projectService;
    }

    @Override
    public void process() {
        System.out.println("Выбрано удаление проекта");
        System.out.println("Введите имя проекта");
        String projectName = scanner.nextLine();
        projectService.deleteByName(projectName);
    }

    @Override
    public String description() {
        String description = pattern + " - Команда удаляет сущность Проект по Имени";
        return description;
    }

    @Override
    public String getName() {
        return pattern;
    }
}
