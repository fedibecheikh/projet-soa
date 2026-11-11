package com.fedi.users.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fedi.users.entities.Role;
import com.fedi.users.entities.User;
import com.fedi.users.repos.RoleRepository;
import com.fedi.users.repos.UserRepository;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRep;
    private final RoleRepository roleRep;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRep, RoleRepository roleRep, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRep = userRep;
        this.roleRep = roleRep;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        if (user.getRoles() == null) {
            user.setRoles(new ArrayList<>());
        }
        return userRep.save(user);
    }

    @Override
    public User addRoleToUser(String username, String rolename) {
        User usr = userRep.findByUsername(username);
        Role r = roleRep.findByRole(rolename);
        if (usr == null || r == null) {
            throw new IllegalArgumentException("Utilisateur ou rôle introuvable : " + username + " / " + rolename);
        }
        if (!usr.getRoles().contains(r)) {
            usr.getRoles().add(r);
        }
        return usr;
    }

    @Override
    public Role addRole(Role role) {
        return roleRep.save(role);
    }

    @Override
    public Role findRoleByRole(String role) {
        return roleRep.findByRole(role);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRep.findByUsername(username);
    }
}
