package com.fedi.users.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fedi.users.entities.User;
import com.fedi.users.service.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserRestController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        // Vérifie si le username est déjà pris
        if (userService.findUserByUsername(user.getUsername()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(Map.of("message", "Nom d'utilisateur déjà utilisé."));
        }

        // Valider les champs minimaux
        if (user.getUsername() == null || user.getUsername().isBlank()
                || user.getPassword() == null || user.getPassword().isBlank()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("message", "Nom d'utilisateur et mot de passe sont obligatoires."));
        }

        user.setEnabled(true);
        User saved = userService.saveUser(user);

        // Affecter automatiquement le rôle USER
        userService.addRoleToUser(saved.getUsername(), "USER");

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("message", "Compte créé avec succès.", "username", saved.getUsername()));
    }
}

