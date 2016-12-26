package com.bondarmih.ticketbooking.service;

import com.bondarmih.ticketbooking.dao.IUserDAO;
import com.bondarmih.ticketbooking.dto.UserDTO;
import com.bondarmih.ticketbooking.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by bondarm on 22.12.16.
 */

@Service
public class UserService {

    @Autowired
    IUserDAO userDAO;

    public User findUserByName(String name) {
        return null;
    }

    public List<UserDTO> getAllUsers() {
        return userDAO.getAllUsers()
                .stream()
                .map(UserDTO::fromUser)
                .collect(Collectors.toList());
    }
}
