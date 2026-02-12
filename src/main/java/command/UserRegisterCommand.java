package command;

import entity.RoleType;
import service.UserService;

import java.util.Scanner;

public class UserRegisterCommand implements Command{
    private final Scanner scanner;
    private final UserService userService;
    String pattern = "register user";

    public UserRegisterCommand(Scanner scanner, UserService userService){
        this.scanner = scanner;
        this.userService = userService;
    }

    @Override
    public void process() {
        System.out.println("Выбрана регистрация пользоватля");
        System.out.println("Введите через пробел логин, пароль и роль");
        String login = scanner.next();
        String password = scanner.next();
        String role = scanner.next();
        userService.registerUser(login, password, role);
    }

    @Override
    public String description() {
        String description = pattern + " - Команда позволяет зарегистрировать пользователя в системе";
        return description;
    }

    @Override
    public String getName() {
        return pattern;
    }
}
