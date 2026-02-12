package command;

import entity.User;
import service.UserService;

@RequiresAuth
public class UserPrintCurrentProfileInfoCommand implements Command{
    private final UserService userService;
    User currentUser;
    String pattern = "print_current_profile_info";

    public UserPrintCurrentProfileInfoCommand(UserService userService, User currentUser){
        this.userService = userService;
        this.currentUser = currentUser;
    }

    @Override
    public void process() {
        System.out.println("Выбран вывод информации профиля текущего пользователя");
        userService.printCurrentProfileInfo(currentUser);
    }

    @Override
    public String description() {
        String description = pattern + " - Команда позволяет вывести информацию о профиле текущего пользователя";
        return description;
    }

    @Override
    public String getName() {
        return pattern;
    }
}
