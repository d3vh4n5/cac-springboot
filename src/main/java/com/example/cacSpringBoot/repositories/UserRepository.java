package com.example.cacSpringBoot.repositories;

import com.example.cacSpringBoot.entities.User;
import com.example.cacSpringBoot.repositories.interfaces.IUserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository implements IUserRepository {
    private List<User> users = new ArrayList<User>();

    public UserRepository(){ // esto lo invento para tener datos
        users.add(new User("Juan", 33));
        users.add(new User("Jorge", 22));
        users.add(new User("Ayrton", 26));
        users.add(new User("Lautaro", 30));
    }

    @Override
    public List<User> findAllUsers() {
        return users;
    }

    @Override
    public void saveUser(User user) {
        users.add(user);
    }

    @Override
    public int findIndex(String name) {
        System.out.println("Buscando: "+name);
        Optional<User> userOpt = users.stream().filter(e -> e.getName().equals(name) ).findFirst();

        if (userOpt.isEmpty()) return -1;

        User user = userOpt.get();

        return users.indexOf(new User(user.getName(), user.getEdad()));
    }

    @Override
    public void updateUser(int targetIndex, User user) {
        users.set(targetIndex, user);
    }


}
