package command;

import entity.User;
import service.UserService;

import java.util.Scanner;

@RequiresAuth
public class UserUpdatePasswordCommand implements Command{
    private final Scanner scanner;
    private final UserService userService;
    String pattern = "update_password";

    public UserUpdatePasswordCommand(Scanner scanner, UserService userService){
        this.scanner = scanner;
        this.userService = userService;
    }

    @Override
    public void process() {
        System.out.println("Выбрано обновление пароля пользователя");
        System.out.println("Введите старый и новый пароли через пробел");
        String oldPassword = scanner.next();
        String newPassword = scanner.next();
        userService.updatePassword(oldPassword, newPassword);
    }

    @Override
    public String description() {
        String description = pattern + " - Команда позволяет поменять пароль текущему пользователю";
        return description;
    }

    @Override
    public String getName() {
        return pattern;
    }
}
