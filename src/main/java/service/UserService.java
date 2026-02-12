package service;

import entity.RoleType;
import repository.UserRepository;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserService {
    private final UserRepository userRepository;

    public UserService(){
        this.userRepository = new UserRepository();
    }

    public void authorizeUser(String login, String password) {
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

            userRepository.authorizeUser(login, checkedPassword.toString());
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

            userRepository.registerUser(login, checkedPassword.toString(), checkedRole);
        }
        catch(NoSuchAlgorithmException | UnsupportedEncodingException e) {
            throw new RuntimeException("Ошибка при генерации MD5 хеша", e);
        }
    }

    public void terminateSession(String login, String password){
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


            userRepository.terminateSession(login, checkedPassword.toString());
        }
        catch(NoSuchAlgorithmException | UnsupportedEncodingException e) {
            throw new RuntimeException("Ошибка при генерации MD5 хеша", e);
        }
    }
}
