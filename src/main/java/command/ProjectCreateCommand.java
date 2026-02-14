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
        System.out.print("Введите id, если такой есть. Если нет, просто нажмите Enter: ");
        String id = null;
        try{
            id = scanner.nextLine();
        }
        catch(NumberFormatException e){
            id = null;
        }
        finally{
            System.out.print("Введите имя: ");
            String name = scanner.nextLine();
            System.out.print("Введите описание: ");
            String description = scanner.nextLine();
            System.out.print("Введите дату начала проекта: ");
            String dateStart = scanner.nextLine();
            System.out.print("Введите дату окончания проекта: ");
            String dateFinish = scanner.nextLine();
            System.out.print("Введите id пользователя: ");
            String userId = scanner.nextLine();
            projectService.create(id, name, description, dateStart, dateFinish, userId);
        }
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
