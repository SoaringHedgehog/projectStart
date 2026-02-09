package command;

import service.ProjectService;
import service.TaskService;

import java.util.Scanner;

public class UpdateByIdTaskCommand implements Command{
    private final Scanner scanner;
    private final TaskService taskService;
    String pattern = "updatebyid task";

    public UpdateByIdTaskCommand(Scanner scanner, TaskService taskService){
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
