package com.example.cacSpringBoot.repositories.interfaces;

import com.example.cacSpringBoot.entities.User;

import java.util.List;

public interface IUserRepository {
    List<User> findAllUsers();
    void saveUser(User user);
    int findIndex(String name);
    void updateUser(int targetIndex, User user);
}
