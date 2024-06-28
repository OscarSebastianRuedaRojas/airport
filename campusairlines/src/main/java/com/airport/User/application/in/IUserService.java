package com.airport.User.application.in;

import java.util.List;

import com.airport.User.domain.User;
import com.airport.User.domain.UserType;

public interface IUserService {
    void registerUser(User user);
    User loginUser(String id, String password);
    String encryptPassword(String password);
    List<UserType> getAllUserTypes();
}
