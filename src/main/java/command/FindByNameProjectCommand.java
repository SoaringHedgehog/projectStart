package command;

import service.ProjectService;
import service.TaskService;

import java.util.Scanner;

public class FindByNameProjectCommand implements Command{
    private final Scanner scanner;
    private final ProjectService projectService;
    String pattern = "findbyname project";

    public FindByNameProjectCommand(Scanner scanner, ProjectService projectService){
        this.scanner = scanner;
        this.projectService = projectService;
    }

    @Override
    public void process() {
        System.out.println("Выбран поиск проекта по имени");
        System.out.println("Введите имя проекта");
        String projectName = scanner.nextLine();
        projectService.findByName(projectName);
    }

    @Override
    public String description() {
        String description = pattern +" - Команда ищет сущность Проект по Имени";
        return description;
    }

    @Override
    public String getName() {
        return pattern;
    }
}
