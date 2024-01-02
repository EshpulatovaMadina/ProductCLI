package org.example.service;

import org.example.models.User;
import org.example.models.enums.UserRole;
import org.example.repository.UserRepo;

import java.util.*;
import java.util.regex.Pattern;

public class UserService {
    UserRepo userRepo = new UserRepo();
    private static final String EMAIL_REGEX = "^(.+)@(.+)$";
    public String save(User userEntity) {
        List<User> all = userRepo.getAll();
        for (User user : all) {
            if(Objects.equals(user.getEmail(),userEntity.getEmail())) {
                return "User already exists with email: "+userEntity.getEmail();
            }
        }

        if(Pattern.matches(EMAIL_REGEX,userEntity.getEmail())) {
            userRepo.save(userEntity);
            return "Successfully signed up✅";
        }
        return "The email is not valid";
    }

    public Optional<User> signIn(String email, String password) {
        List<User> all = userRepo.getAll();
        for (User user : all) {
            if(Objects.equals(user.getEmail(),email)) {
                if (Objects.equals(user.getPassword(),password)) {
                    return Optional.of(user);
                }
                System.out.println("Password didn't match");
            }
        }
        System.out.println("User not found with email: "+ email);
        return Optional.empty();
    }


    public List<User> getAllUsers(UserRole userRole) {
        List<User> all = userRepo.getAll();
        List<User> users = new ArrayList<>();
        for (User user : all) {
            if(Objects.equals(user.getRole(),userRole)) {
                users.add(user);
            }
        }
        return users;
    }

    public String updateRole(UUID id, UserRole userRole) {
       return userRepo.updateRole(id,userRole);
    }
}
