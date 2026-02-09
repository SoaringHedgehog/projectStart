package command;

import service.ProjectService;
import service.TaskService;

import java.util.Scanner;

public class UpdateByNameProjectCommand implements Command{
    private final Scanner scanner;
    private final ProjectService projectService;
    String pattern = "updatebyname project";

    public UpdateByNameProjectCommand(Scanner scanner, ProjectService projectService){
        this.scanner = scanner;
        this.projectService = projectService;
    }

    @Override
    public void process() {
        System.out.println("Выбрано обновление проекта по имени");
        System.out.println("Введите имя проекта, поле для изменения и новое значение");
        String project = scanner.nextLine();
        projectService.updateByName(project);
    }

    @Override
    public String description() {
        String description = pattern + " - Команда обновляет(изменяет) сущность Проект по Имени";
        return description;
    }

    @Override
    public String getName() {
        return pattern;
    }
}
