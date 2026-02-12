package service;

import entity.RoleType;
import entity.User;
import repository.UserRepository;
import repository.UserRepositoryImpl;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserService {
    private final UserRepository userRepositoryImpl;
    User currentUser;

    public UserService(){
        this.userRepositoryImpl = new UserRepositoryImpl();
    }

    public void authorizeUser(String login, String password, User currentUser) {
        if(currentUser != null){
            System.out.println("Вход уже выполнен");
            return;
        }

        if(login == null || login.isEmpty()){
            System.out.println("Логин не может быть пустым");
            return;
        }

        if(password == null || password.isEmpty()){
            System.out.println("Пароль не может быть пустым");
            return;
        }

        try{
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] inputBytes = password.getBytes("UTF-8");
            md5.update(inputBytes);
            byte[] hashBytes = md5.digest();
            // Преобразование массива байтов в шестнадцатеричную строку
            StringBuilder checkedPassword = new StringBuilder();
            for (byte b : hashBytes) {
                // Преобразование каждого байта в две шестнадцатеричные цифры
                checkedPassword.append(String.format("%02x", b & 0xff));
            }

            userRepositoryImpl.authorizeUser(login, checkedPassword.toString(), currentUser);
        }
        catch(NoSuchAlgorithmException | UnsupportedEncodingException e) {
            throw new RuntimeException("Ошибка при генерации MD5 хеша", e);
        }
    }

    public void registerUser(String login, String password, String role) {
        if(login == null || login.isEmpty()){
            System.out.println("Логин не может быть пустым");
            return;
        }

        if(password == null || password.isEmpty()){
            System.out.println("Пароль не может быть пустым");
            return;
        }

        if(role == null || role.isEmpty()){
            System.out.println("Роль не может быть пустой");
            return;
        }

        try{
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] inputBytes = password.getBytes("UTF-8");
            md5.update(inputBytes);
            byte[] hashBytes = md5.digest();
            // Преобразование массива байтов в шестнадцатеричную строку
            StringBuilder checkedPassword = new StringBuilder();
            for (byte b : hashBytes) {
                // Преобразование каждого байта в две шестнадцатеричные цифры
                checkedPassword.append(String.format("%02x", b & 0xff));
            }

            RoleType checkedRole = RoleType.valueOf(role);

            userRepositoryImpl.registerUser(login, checkedPassword.toString(), checkedRole);
        }
        catch(NoSuchAlgorithmException | UnsupportedEncodingException e) {
            throw new RuntimeException("Ошибка при генерации MD5 хеша", e);
        }
    }

    public void terminateSession(User currentUser){
        if(currentUser == null){
            System.out.println("Пользователь и так не в сети");
        }
        userRepositoryImpl.terminateSession(currentUser);
    }

    public void updatePassword(String oldPassword, String newPassword){
        if(oldPassword == null || oldPassword.isEmpty()){
            System.out.println("Старый пароль не может быть пустым");
            return;
        }

        if(newPassword == null || newPassword.isEmpty()){
            System.out.println("Нвоый пароль не может быть пустым");
            return;
        }

        try{
            MessageDigest md5_1 = MessageDigest.getInstance("MD5");
            byte[] inputBytes = oldPassword.getBytes("UTF-8");
            md5_1.update(inputBytes);
            byte[] hashBytes = md5_1.digest();
            // Преобразование массива байтов в шестнадцатеричную строку
            StringBuilder checkedOldPassword = new StringBuilder();
            for (byte b : hashBytes) {
                // Преобразование каждого байта в две шестнадцатеричные цифры
                checkedOldPassword.append(String.format("%02x", b & 0xff));
            }

            MessageDigest md5_2 = MessageDigest.getInstance("MD5");
            inputBytes = oldPassword.getBytes("UTF-8");
            md5_2.update(inputBytes);
            hashBytes = md5_2.digest();
            // Преобразование массива байтов в шестнадцатеричную строку
            StringBuilder checkedNewPassword = new StringBuilder();
            for (byte b : hashBytes) {
                // Преобразование каждого байта в две шестнадцатеричные цифры
                checkedNewPassword.append(String.format("%02x", b & 0xff));
            }

            userRepositoryImpl.updatePassword(checkedOldPassword.toString(), checkedNewPassword.toString());
        }
        catch(NoSuchAlgorithmException | UnsupportedEncodingException e) {
            throw new RuntimeException("Ошибка при генерации MD5 хеша", e);
        }
    }

    public void printCurrentProfileInfo(User currentUser){
        userRepositoryImpl.printCurrentProfileInfo(currentUser);
    }
}
