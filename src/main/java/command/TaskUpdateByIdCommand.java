package command;

import service.TaskService;

import java.util.Scanner;

@RequiresAuth
public class TaskUpdateByIdCommand implements Command{
    private final Scanner scanner;
    private final TaskService taskService;
    String pattern = "update_by_id task";

    public TaskUpdateByIdCommand(Scanner scanner, TaskService taskService){
        this.scanner = scanner;
        this.taskService = taskService;
    }

    @Override
    public void process() {
        System.out.println("Выбрано обновление задачи по id");
        System.out.println("Введите id задачи, поле для изменения и новое значение");
        int taskId = Integer.parseInt(scanner.nextLine());
        taskService.updateById(taskId);
    }

    @Override
    public String description() {
        String description = pattern + " - Команда обновляет(изменяет) сущность Задача по ID";
        return description;
    }

    @Override
    public String getName() {
        return pattern;
    }
}
