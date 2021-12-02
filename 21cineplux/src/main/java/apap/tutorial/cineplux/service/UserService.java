package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.UserModel;

import java.util.List;

public interface UserService {
    UserModel addUser(UserModel user);
    String encrypt(String password);
<<<<<<< HEAD
    UserModel getUserByUsername(String username);
    void updatePassword(UserModel user, String newPass);
    List<UserModel> getUserList();
    void deleteUser(UserModel user);
}
=======

>>>>>>> 51154897d58f4e827f9eda373b239024c3e9b180
