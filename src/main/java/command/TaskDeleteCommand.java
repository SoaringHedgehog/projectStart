package command;

import service.TaskService;

import java.util.Scanner;

@RequiresAuth
public class TaskDeleteCommand implements Command{
    private final Scanner scanner;
    private final TaskService taskService;
    String pattern = "deleteByName task";

    public TaskDeleteCommand(Scanner scanner, TaskService taskService){
        this.scanner = scanner;
        this.taskService = taskService;
    }

    @Override
    public void process() {
        System.out.println("Выбрано удаление задачи");
        System.out.println("Введите имя задачи");
        String taskName = scanner.nextLine();
        taskService.deleteByName(taskName);
    }

    @Override
    public String description() {
        String description = pattern +" - Команда удаляет сущность Задача по Имени";
        return description;
    }

    @Override
    public String getName() {
        return pattern;
    }
}
