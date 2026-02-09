package command;

import service.ProjectService;
import service.TaskService;

import java.util.Scanner;

public class UpdateByIdTaskCommand implements Command{
    private final Scanner scanner;
    private final TaskService taskService;

    public UpdateByIdTaskCommand(Scanner scanner, TaskService taskService){
        this.scanner = scanner;
        this.taskService = taskService;
    }

    @Override
    public void process() {
        System.out.println("Выбрано обновление задачи по id");
        System.out.println("Введите id задачи");
        int taskId = Integer.parseInt(scanner.nextLine());
        taskService.updateById(taskId);
    }

    @Override
    public String description() {
        String description = "Команда обновляет(изменяет) сущность Задача по ID";
        return description;
    }
}
