package com.example.springboot.Service;

import com.example.springboot.Model.User;

import java.util.List;

public interface UserService {
    public void addNewUser(User user);

    public void updateUser(User user);

    public List<User> displayAllUsers() ;

    public User getUserById(Long id);

    public void deleteUser(Long id);
}
