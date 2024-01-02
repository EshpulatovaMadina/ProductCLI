package org.example.controller;

import org.example.models.User;

import java.util.List;

import static org.example.models.enums.UserRole.ADMIN;
import static org.example.models.enums.UserRole.USER;
import static org.example.util.Util.USER_SERVICE;
import static org.example.util.Util.scannerNum;

public class SuperAdminUi {
    public static void superAdminUi() {
        int i = 0;
        while (true) {
            System.out.println("""
                    1. Set new admin
                    2. Show admins
                    0.Exit
                    """);
            i = scannerNum.nextInt();
            switch (i) {
                case 1 -> setAdmin();
                case 2 -> showAdmins();
                case 0 -> {
                    return;
                }
                default -> System.out.println("Unexpected value");
            }
        }
    }

    private static void showAdmins() {
        List<User> users = USER_SERVICE.getAllUsers(ADMIN);
        if(users.isEmpty()) {
            System.out.println("No admin");
        }
        int i = 1;
        for (User user : users) {
            System.out.print(i);
            System.out.println(user.toString());
            i++;
        }

    }

    private static void setAdmin() {
        List<User> users = USER_SERVICE.getAllUsers(USER);
        if(users.isEmpty()) {
            System.out.println("No user");
            return;
        }
        int i = 1;
        for (User user : users) {
            System.out.print(i);
            System.out.println(user.toString());
            i++;
        }

        int index;

        System.out.print("Select user index: ");
        index = scannerNum.nextInt();
        if(index < 1 || index - 1 > users.size() - 1) {
            System.out.println("User not found");
            return;
        }

        User userEntity = users.get(index-1);
        System.out.println(USER_SERVICE.updateRole(userEntity.getId(), ADMIN));
    }
}
