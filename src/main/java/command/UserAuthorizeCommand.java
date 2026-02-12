package command;

import service.UserService;

import java.util.Scanner;

public class UserAuthorizeCommand implements Command{
    private final Scanner scanner;
    private final UserService userService;
    String pattern = "authorize user";

    public UserAuthorizeCommand(Scanner scanner, UserService userService){
        this.scanner = scanner;
        this.userService = userService;
    }

    @Override
    public void process() {
        System.out.println("Выбрана авторизация пользоватля");
        System.out.println("Введите через пробел логин и пароль");
        String login = scanner.next();
        String password = scanner.next();
        userService.authorizeUser(login, password);
    }

    @Override
    public String description() {
        String description = pattern + " - Команда позволяет войти в систему при верных введённых данных логина и пароля";
        return description;
    }

    @Override
    public String getName() {
        return pattern;
    }
}
