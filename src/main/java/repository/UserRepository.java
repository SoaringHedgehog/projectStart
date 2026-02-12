package repository;

import entity.RoleType;
import entity.User;

import java.util.HashMap;
import java.util.Objects;

public class UserRepository {
    // Map<login, user>
    private HashMap<String, User> userMap;

    public void authorizeUser(String login, String passwordHash){
        User user = userMap.get(login);
        if(user == null){
            System.out.println("Пользователя с таким логином не найден");
            return;
        }
        if(Objects.equals(user.getPasswordHash(), passwordHash)){
            System.out.println("Пользователь авторизован");
        }
        else{
            System.out.println("Неверный пароль");
        }
    }

    public void registerUser(String login, String passwordHash, RoleType role){
        if(!userMap.containsKey(login)){
            User user = new User(login, passwordHash, role);
            userMap.put(login, user);
        }
        else{
            System.out.println("Такой логин уже занят. Попробуйте другой");
        }
    }

    public void terminateSession(String login, String passwordHash){
        System.out.println("Сессия закрыта");
    }

    public void updatePassword(User user, String newPasswordHash){
        User userForChangePassword = user;

    }

    public void printCurrentProfile(User user){
        System.out.println(user.toString());
    }
}
