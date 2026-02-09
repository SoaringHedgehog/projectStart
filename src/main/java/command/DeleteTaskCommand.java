package command;

import service.ProjectService;
import service.TaskService;

import java.util.Scanner;

public class DeleteTaskCommand implements Command{
    private final Scanner scanner;
    private final TaskService taskService;

    public DeleteTaskCommand(Scanner scanner, TaskService taskService){
        this.scanner = scanner;
        this.taskService = taskService;
    }

    @Override
    public void process() {
        System.out.println("Выбрано удаление задачи");
        System.out.println("Введите имя задачи");
        String taskName = scanner.nextLine();
        taskService.delete(taskName);
    }

    @Override
    public String description() {
        String description = "Команда удаляет сущность Задача по Имени";
        return description;
    }
}
