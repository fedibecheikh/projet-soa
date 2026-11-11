package com.fedi.users.service;

import com.fedi.users.entities.Role;
import com.fedi.users.entities.User;

public interface UserService {
    User saveUser(User user);
    User findUserByUsername(String username);
    Role addRole(Role role);
    Role findRoleByRole(String role);
    User addRoleToUser(String username, String rolename);
}