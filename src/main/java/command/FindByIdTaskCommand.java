package command;

import service.ProjectService;
import service.TaskService;

import java.util.Scanner;

public class FindByIdTaskCommand implements Command{
    private final Scanner scanner;
    private final TaskService taskService;
    String pattern = "findbyid task";

    public FindByIdTaskCommand(Scanner scanner, TaskService taskService){
        this.scanner = scanner;
        this.taskService = taskService;
    }

    @Override
    public void process() {
        System.out.println("Выбран поиск задачи по id");
        System.out.println("Введите id проекта");
        int taskId = Integer.parseInt(scanner.nextLine());
        taskService.findById(taskId);
    }

    @Override
    public String description() {
        String description = pattern + " - Команда ищет сущность Задача по ID";
        return description;
    }

    @Override
    public String getName() {
        return pattern;
    }
}
