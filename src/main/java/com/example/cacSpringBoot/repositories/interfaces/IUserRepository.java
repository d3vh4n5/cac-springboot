package com.example.cacSpringBoot.repositories.interfaces;

import com.example.cacSpringBoot.dto.request.ReqNameDto;
import com.example.cacSpringBoot.entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    List<User> findAllUsers();
    void saveUser(User user);
    int findIndex(String name);
    void updateUser(int targetIndex, User user);
    Optional<User> findOne(ReqNameDto reqNameDto);
}
