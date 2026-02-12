package command;

import entity.User;
import service.UserService;

import java.util.Scanner;

public class UserAuthorizeCommand implements Command{
    private final Scanner scanner;
    private final UserService userService;
    User currentUser;
    String pattern = "authorize user";

    public UserAuthorizeCommand(Scanner scanner, UserService userService, User currentUser){
        this.scanner = scanner;
        this.userService = userService;
        this.currentUser = currentUser;
    }

    @Override
    public void process() {
        System.out.println("Выбрана авторизация пользователя");
        System.out.println("Введите через пробел логин и пароль");
        String login = scanner.next();
        String password = scanner.next();
        userService.authorizeUser(login, password, currentUser);
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
