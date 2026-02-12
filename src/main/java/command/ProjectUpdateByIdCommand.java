package command;

import service.ProjectService;

import java.util.Scanner;

@RequiresAuth
public class ProjectUpdateByIdCommand implements Command{
    private final Scanner scanner;
    private final ProjectService projectService;
    String pattern = "updatebyid project";

    public ProjectUpdateByIdCommand(Scanner scanner, ProjectService projectService){
        this.scanner = scanner;
        this.projectService = projectService;
    }

    @Override
    public void process() {
        System.out.println("Выбрано обновление проекта по id");
        System.out.println("Введите id проекта, поле для изменения и новое значение");
        int projectId = Integer.parseInt(scanner.nextLine());
        String field = scanner.next();
        String newValue = scanner.next(); // TODO правильный формат?
        projectService.updateById(projectId);
    }

    @Override
    public String description() {
        String description = pattern + " - Команда обновляет(изменяет) сущность Проект по ID";
        return description;
    }

    @Override
    public String getName() {
        return pattern;
    }
}
