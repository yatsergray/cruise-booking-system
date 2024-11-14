package com.cruiseline.cruiseline.service;

import com.cruiseline.cruiseline.entity.User;
import com.cruiseline.cruiseline.exception.NoSuchUserExistsException;

import java.util.List;

public interface UserService {
    void addUser(User user);

    void updateUserById(Long id, Long roleId, String name, String surname, String email, String password);

    void removeUserById(Long id);

    void removeUser(User user);

    User getUserById(Long id) throws NoSuchUserExistsException;

    List<User> getAllUsers();
}
