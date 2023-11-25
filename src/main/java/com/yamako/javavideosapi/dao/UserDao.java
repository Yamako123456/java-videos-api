package com.yamako.javavideosapi.dao;

import com.yamako.javavideosapi.model.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();
    User getUserById(int id);
    User getUserByUsername(String username);

}
