package command;

import entity.RoleType;
import entity.User;
import service.UserService;

import java.util.Scanner;

public class UserRegisterCommand implements Command{
    private final Scanner scanner;
    private final UserService userService;
    User currentUser;
    String pattern = "register user";

    public UserRegisterCommand(Scanner scanner, UserService userService, User currentUser){
        this.scanner = scanner;
        this.userService = userService;
        this.currentUser = currentUser;
    }

    @Override
    public void process() {
        System.out.println("Выбрана регистрация пользователя");
        System.out.println("Введите через пробел логин, пароль и роль. Пример: login password USER");
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
