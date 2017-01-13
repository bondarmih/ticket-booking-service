package com.bondarmih.ticketbooking.service;

import com.bondarmih.ticketbooking.data.dao.IUserDAO;
import com.bondarmih.ticketbooking.data.dao.UserDAO;
import com.bondarmih.ticketbooking.data.entity.User;
import com.bondarmih.ticketbooking.service.dto.UserDTO;
import com.bondarmih.ticketbooking.service.dto.builder.UserDtoBulder;
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

    public UserDTO findUserByName(String name) {
        UserDTO user = UserDtoBulder.fromUser(userDAO.getUserByName(name));
        if (user == null) {
            user = new UserDTO();
            user.setName(null);
        }
        return user;
    }

    public List<UserDTO> getAllUsers() {
        return userDAO.getAllUsers()
                .stream()
                .map(UserDtoBulder::fromUser)
                .collect(Collectors.toList());
    }

    public UserDTO getUserById(long id) {
        return UserDtoBulder.fromUser(userDAO.getUserById(id));
    }
}
