package com.airport.User.application.out;

import java.util.List;

import com.airport.User.domain.User;
import com.airport.User.domain.UserType;

public interface UserRepositoryPort {
    void save(User user);
    User findById(String id);
    List<UserType> findAllUserTypes();
}
