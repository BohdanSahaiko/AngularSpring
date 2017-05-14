package com.service;

import com.Entity.User;

/**
 * Created by bohdan on 14/05/17.
 */
public interface UserService {
    User findUserByName(String name);
    void saveUser(User user);
}
