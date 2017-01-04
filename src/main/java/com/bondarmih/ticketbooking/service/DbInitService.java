package com.bondarmih.ticketbooking.service;

import com.bondarmih.ticketbooking.data.dao.IUserDAO;
import com.bondarmih.ticketbooking.data.dao.IUserRoleDAO;
import com.bondarmih.ticketbooking.data.entity.User;
import com.bondarmih.ticketbooking.data.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by bondarm on 25.12.16.
 */

@Service
@Transactional
public class DbInitService {

    @Autowired
    private IUserDAO userDAO;

    @Autowired
    private IUserRoleDAO userRoleDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void dbInit() {

        userDAO.truncateUsers();
        userRoleDAO.truncateUserRoles();
        UserRole roleUser = new UserRole();
        roleUser.setName("ROLE_USER");
        userRoleDAO.addUserRole(roleUser);

        UserRole roleAdmin = new UserRole();
        roleAdmin.setName("ROLE_ADMIN");
        userRoleDAO.addUserRole(roleAdmin);

        User userAdmin = new User();
        userAdmin.setName("admin");
        String hash = passwordEncoder.encode("adminpass");
        userAdmin.setPassword(hash);
        Set<UserRole> roles = new HashSet<>();
        roles.add(roleAdmin);
        roles.add(roleUser);
        userAdmin.setRoles(roles);
        if (userDAO.getUserByName("admin") == null) {
            userDAO.addUser(userAdmin);
            System.out.println("admin added");

        }
    }
}