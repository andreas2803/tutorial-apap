package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.UserModel;

import java.util.List;

public interface UserService {
    UserModel addUser(UserModel user);
    String encrypt(String password);
    UserModel getUserByUsername(String username);
    void updatePassword(UserModel user, String newPass);
    List<UserModel> getUserList();
    void deleteUser(UserModel user);
}
