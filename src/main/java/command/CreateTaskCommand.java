package command;

import service.TaskService;

import java.util.Scanner;

public class CreateTaskCommand implements Command{
    private final Scanner scanner;
    private final TaskService taskService;
    String pattern = "create task";

    public CreateTaskCommand(Scanner scanner, TaskService taskService){
        this.scanner = scanner;
        this.taskService = taskService;
    }

    @Override
    public void process() {
        System.out.println("Выбрано создание задачи");
        System.out.println("Введите через пробел имя, описание, дату начала и дату окончания задачи");
        String task = scanner.nextLine();
        taskService.create(task);
    }

    @Override
    public String description() {
        String description = pattern + " - Команда создаёт сущность Задача";
        return description;
    }

    @Override
    public String getName() {
        return pattern;
    }
}
