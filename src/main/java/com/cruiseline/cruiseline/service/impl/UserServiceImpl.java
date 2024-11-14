package com.cruiseline.cruiseline.service.impl;

import com.cruiseline.cruiseline.dao.UserDAO;
import com.cruiseline.cruiseline.entity.User;
import com.cruiseline.cruiseline.exception.NoSuchUserExistsException;
import com.cruiseline.cruiseline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public void addUser(User user) {
        userDAO.save(user);
    }

    @Override
    public void updateUserById(Long id, Long roleId, String name, String surname, String email, String password) {
        userDAO.updateUserById(id, roleId, name, surname, email, password);
    }

    @Override
    public void removeUserById(Long id) {
        userDAO.deleteById(id);
    }

    @Override
    public void removeUser(User user) {
        userDAO.delete(user);
    }

    @Override
    public User getUserById(Long id) throws NoSuchUserExistsException {
        return Optional.of(userDAO.getById(id)).orElseThrow(() -> new NoSuchUserExistsException("User with id " + id + " doesn't exist."));
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.findAll();
    }
}
