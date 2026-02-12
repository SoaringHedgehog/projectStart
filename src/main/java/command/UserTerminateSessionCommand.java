package command;

import entity.User;
import service.UserService;

import java.util.Scanner;

@RequiresAuth
public class UserTerminateSessionCommand implements Command{
    private final Scanner scanner;
    private final UserService userService;
    User currentUser;
    String pattern = "terminate_current_session";

    public UserTerminateSessionCommand(Scanner scanner, UserService userService, User currentUser){
        this.scanner = scanner;
        this.userService = userService;
        this.currentUser = currentUser;
    }

    @Override
    public void process() {
        System.out.println("Выбрано окончание сессии текущего пользователя");
        userService.terminateSession(currentUser);
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
