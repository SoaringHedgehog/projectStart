package command;

import service.ProjectService;

import java.util.Scanner;

public class FindByIdProjectCommand implements Command{
    private final Scanner scanner;
    private final ProjectService projectService;

    public FindByIdProjectCommand(Scanner scanner, ProjectService projectService){
        this.scanner = scanner;
        this.projectService = projectService;
    }

    @Override
    public void process() {
        System.out.println("Выбран поиск проекта по id");
        System.out.println("Введите id проекта");
        int projectId = Integer.parseInt(scanner.nextLine());
        projectService.findById(projectId);
    }

    @Override
    public String description() {
        String description = "Команда ищет сущность Проект по ID";
        return description;
    }
}
