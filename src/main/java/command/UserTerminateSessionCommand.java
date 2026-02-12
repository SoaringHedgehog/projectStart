package command;

import service.UserService;

import java.util.Scanner;

@RequiresAuth
public class UserTerminateSessionCommand implements Command{
    private final Scanner scanner;
    private final UserService userService;
    String pattern = "terminatecurrentsession";

    public UserTerminateSessionCommand(Scanner scanner, UserService userService){
        this.scanner = scanner;
        this.userService = userService;
    }

    @Override
    public void process() {
        System.out.println("Выбрано окончание сессии пользоватля");
        System.out.println("Введите через пробел логин и пароль");
        String login = scanner.next();
        String password = scanner.next();
        userService.terminateSession(login, password);
    }

    @Override
    public String description() {
        String description = pattern + " - Команда позволяет завершить пользователя в системе";
        return description;
    }

    @Override
    public String getName() {
        return pattern;
    }
}
