package com.airport.User.application.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.airport.User.application.in.IUserService;
import com.airport.User.domain.User;
import com.airport.User.domain.UserType;
import com.airport.User.infrastructure.adapter.out.UserRepository;

public class UserService implements IUserService{
    private UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepository();
    }

    @Override
    public void registerUser(User user) {
        user.setPassword(encryptPassword(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public User loginUser(String id, String password) {
        User user = userRepository.findById(id);
        if (user != null && user.getPassword().equals(encryptPassword(password))) {
            return user;
        }
        return null;
    }

    @Override
    public String encryptPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<UserType> getAllUserTypes() {
        return userRepository.findAllUserTypes();
    }
}
