package command;

import service.ProjectService;
import service.TaskService;

import java.util.Scanner;

public class FindByNameTaskCommand implements Command{
    private final Scanner scanner;
    private final TaskService taskService;
    String pattern = "findbyname task";

    public FindByNameTaskCommand(Scanner scanner, TaskService taskService){
        this.scanner = scanner;
        this.taskService = taskService;
    }

    @Override
    public void process() {
        System.out.println("Выбран поиск задачи по имени");
        System.out.println("Введите имя задачи");
        String projectName = scanner.nextLine();
        taskService.findByName(projectName);
    }

    @Override
    public String description() {
        String description = pattern + " - Команда ищет сущность Задача по Имени";
        return description;
    }
}
