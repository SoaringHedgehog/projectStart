package command;

import service.ProjectService;
import service.TaskService;

import java.util.Scanner;

public class UpdateByNameTaskCommand implements Command{
    private final Scanner scanner;
    private final TaskService taskService;
    String pattern = "updatebyname task";

    public UpdateByNameTaskCommand(Scanner scanner, TaskService taskService){
        this.scanner = scanner;
        this.taskService = taskService;
    }

    @Override
    public void process() {
        System.out.println("Выбрано обновление задачи по имени");
        System.out.println("Введите имя задачи, поле для изменения и новое значение");
        String task = scanner.nextLine();
        taskService.updateByName(task);
    }

    @Override
    public String description() {
        String description = pattern + " - Команда обновляет(изменяет) сущность Проект по Имени";
        return description;
    }
}
