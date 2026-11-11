package com.fedi.users;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fedi.users.entities.Role;
import com.fedi.users.entities.User;
import com.fedi.users.service.UserService;

@SpringBootApplication
public class UsersMicroserviceApplication {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(UsersMicroserviceApplication.class, args);
    }

    @PostConstruct
    void init_users() {
        // Ajouter les rôles s'ils n'existent pas
        if (userService.findRoleByRole("ADMIN") == null) {
            userService.addRole(new Role(null, "ADMIN"));
        }
        if (userService.findRoleByRole("USER") == null) {
            userService.addRole(new Role(null, "USER"));
        }

        // Ajouter les utilisateurs s'ils n'existent pas
        if (userService.findUserByUsername("admin") == null) {
            userService.saveUser(new User(null, "admin", "123", true, null));
            userService.addRoleToUser("admin", "ADMIN");
            userService.addRoleToUser("admin", "USER");
        }
        if (userService.findUserByUsername("fedi") == null) {
            userService.saveUser(new User(null, "fedi", "123", true, null));
            userService.addRoleToUser("fedi", "USER");
        }
        if (userService.findUserByUsername("yassine") == null) {
            userService.saveUser(new User(null, "yassine", "123", true, null));
            userService.addRoleToUser("yassine", "USER");
        }
    }
}

