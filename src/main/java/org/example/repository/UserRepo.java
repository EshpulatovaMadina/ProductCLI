package org.example.repository;

import org.example.models.User;
import org.example.models.enums.UserRole;

import java.util.*;

public class UserRepo implements BaseRepo<User> {
    String path = "src\\main\\resources\\user.json";
    @Override
    public Optional<User> save(User user) {
        ArrayList<User> users = (ArrayList<User>) readFromFile(path, User.class);
        for (User user1 : users) {
            if (Objects.equals(user1.getEmail(),user.getEmail())) {
                return Optional.empty();
            }
        }
        users.add(user);
        writeToFile(users,path);
        return Optional.of(user);
    }

    @Override
    public List<User> getAll() {
        return readFromFile(path, User.class);
    }

    public String updateRole(UUID userId, UserRole userRole) {
        List<User> users = getAll();
        for (User user : users) {
            if(Objects.equals(user.getId(),(userId))) {
                user.setRole(userRole);
            }
        }
        writeToFile(users,path);
        return "Role updated";

    }
}
