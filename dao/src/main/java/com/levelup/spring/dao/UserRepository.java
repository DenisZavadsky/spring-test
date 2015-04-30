package com.levelup.spring.dao;

import com.levelup.spring.model.user.User;

import java.util.List;

/**
 * Created by denis_zavadsky on 3/14/15.
 */
public interface UserRepository {

    void createUser(User user);

    User getUserById(Long id);
    User getUserByName(String firstName, String lastName);

    List<User> getAllUsers();
    User getUserByLogin(String login);
}
