package org.example.controller;

import org.example.models.*;

import java.util.Optional;

import static org.example.models.enums.UserRole.USER;
import static org.example.util.Util.*;

public class MainUi {
    public static void main() {

//        User superAdmin = new User(
//                "Oyatillo",
//                "oyatillo@gmail.com",
//                "meliboyev",
//                SUPER_ADMIN
//        );
//        USER_SERVICE.addSuperAdmin(superAdmin);


        int i = 0;
        while (true) {
            System.out.println("""
                    1.Sign in
                    2.Sign up
                    """);
            i = scannerNum.nextInt();
            switch (i) {
                case 1 -> {
                    System.out.print("Enter email: ");
                    String email = scannerStr.nextLine();

                    System.out.print("Enter password: ");
                    String password = scannerStr.nextLine();
                    Optional<User> userEntity = USER_SERVICE.signIn(email, password);
                    if(userEntity.isPresent()) {
                        switch (userEntity.get().getRole()) {
                            case USER -> UserUi.userUi();
                            case ADMIN -> AdminUI.adminUi();
                            case SUPER_ADMIN -> SuperAdminUi.superAdminUi();
                            default -> System.out.println("Unauthorized or blocked");
                        }
                        break;
                    }
                    System.out.println("User not found with email: " + email);
                }
                case 2 -> {
                    System.out.print("Enter name: ");
                    String name = scannerStr.nextLine();

                    System.out.print("Enter email: ");
                    String email = scannerStr.nextLine();

                    System.out.print("Enter password: ");
                    String password = scannerStr.nextLine();

                    User userEntity = new User(name,email,password, USER);
                    System.out.println(USER_SERVICE.save(userEntity));
                }
            }
        }
    }

}
