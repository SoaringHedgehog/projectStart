package command;

import service.ProjectService;

import java.util.Scanner;

public class CreateProjectCommand implements Command{
    private final Scanner scanner;
    private final ProjectService projectService;

    public CreateProjectCommand(Scanner scanner, ProjectService projectService){
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
        String description = "Команда создаёт сущность Проект";
        return description;
    }
}
