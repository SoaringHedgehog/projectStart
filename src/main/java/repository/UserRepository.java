package repository;

import entity.RoleType;
import entity.User;

public interface UserRepository {
    void authorizeUser(String login, String passwordHash, User currentUser);
    void registerUser(String login, String passwordHash, RoleType role);
    void terminateSession(User currentUser);
    void updatePassword(String oldPasswordHash, String newPasswordHash);
    void printCurrentProfileInfo(User currentUser);
}
