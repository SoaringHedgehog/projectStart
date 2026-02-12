package repository;

import entity.RoleType;
import entity.User;

import java.util.HashMap;
import java.util.Objects;

public class UserRepositoryImpl implements UserRepository{
    // Map<login, user>
    private HashMap<String, User> userMap;

    public UserRepositoryImpl(){
        this.userMap = new HashMap<>();
    }

    @Override
    public void authorizeUser(String login, String passwordHash, User currentUser){
        User user = userMap.get(login);
        if(user == null){
            System.out.println("Пользователь с таким логином не найден");
            return;
        }

        if(Objects.equals(user.getPasswordHash(), passwordHash)){
            currentUser = userMap.get(login);
            System.out.println("Пользователь авторизован");
        }
        else{
            System.out.println("Неверный пароль");
        }
    }

    @Override
    public void registerUser(String login, String passwordHash, RoleType role){
        if(!userMap.containsKey(login)){
            User user = new User(login, passwordHash, role);
            userMap.put(login, user);
            System.out.println("Пользователь успешно зарегистрирован");
        }
        else{
            System.out.println("Такой логин уже занят. Попробуйте другой");
        }
    }

    @Override
    public void terminateSession(User currentUser){
        currentUser = null;
        System.out.println("Сессия закрыта");
    }

    @Override
    public void updatePassword(String oldPasswordHash, String newPasswordHash){

    }

    @Override
    public void printCurrentProfileInfo(User currentUser){
        System.out.println(currentUser.toString());
    }
}
