package command;

import service.ProjectService;

import java.util.Scanner;

public class UpdateByIdProjectCommand implements Command{
    private final Scanner scanner;
    private final ProjectService projectService;

    public UpdateByIdProjectCommand(Scanner scanner, ProjectService projectService){
        this.scanner = scanner;
        this.projectService = projectService;
    }

    @Override
    public void process() {
        System.out.println("Выбрано обновление проекта по id");
        System.out.println("Введите id проекта");
        int projectId = Integer.parseInt(scanner.nextLine());
        projectService.updateById(projectId);
    }

    @Override
    public String description() {
        String description = "Команда обновляет(изменяет) сущность Проект по ID";
        return description;
    }
}
