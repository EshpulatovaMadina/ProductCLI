package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.models.enums.UserRole;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User extends BaseModel {
    private String name;
    private String email;
    private String password;
    private UserRole role;

    @Override
    public String toString() {
        return " |name     : " + name + '\n' +
               "  |email    : " + email + '\n' +
               "  |password : " + password + '\n' +
               "  |role     : " + role + '\n';
    }
}
