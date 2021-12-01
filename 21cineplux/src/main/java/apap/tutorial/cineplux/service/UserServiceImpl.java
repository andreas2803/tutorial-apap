package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.UserModel;
import apap.tutorial.cineplux.repository.UserDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional

public class UserServiceImpl implements UserService {
    @Autowired
    private UserDB userDb;

    @Override
    public UserModel addUser(UserModel user) {
        String pass = encrypt(user.getPassword());

        return userDb.save(user);
    }

    @Override
    public String encrypt(String password) {

        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }

    @Override

    public UserModel getUserByUsername(String username) {
        return userDb.findByUsername(username);
    }

    @Override

