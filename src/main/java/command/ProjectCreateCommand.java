package command;

import service.ProjectService;

import java.util.Scanner;

@RequiresAuth
public class ProjectCreateCommand implements Command{
    private final Scanner scanner;
    private final ProjectService projectService;
    public final static String pattern = "create project";

    public ProjectCreateCommand(Scanner scanner, ProjectService projectService){
        this.scanner = scanner;
        this.projectService = projectService;
    }

    @Override
    public void process() {
        System.out.println("Выбрано создание проекта");
        System.out.println("Введите через пробел имя, описание, дату начала и дату окончания проекта");
        String project = scanner.nextLine();
        projectService.create(project);
    }

    @Override
    public String description() {
        String description = pattern + " - Команда создаёт сущность Проект";
        return description;
    }

    @Override
    public String getName() {
        return pattern;
    }
}
