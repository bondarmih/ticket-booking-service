package com.bondarmih.ticketbooking.service.dto.builder;

import com.bondarmih.ticketbooking.data.entity.User;
import com.bondarmih.ticketbooking.service.dto.UserDTO;

import java.util.Date;

/**
 * Created by bondarm on 07.01.17.
 */
public class UserDtoBulder {

    public static UserDTO fromUser(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setDateOfBirth(user.getDateOfBirth());
        return userDTO;
    }

    public static UserDTO anonymousUser() {
        UserDTO userDTO = new UserDTO();
        userDTO.setName("anonymous");
        userDTO.setId(0);
        userDTO.setDateOfBirth(new Date());
        return userDTO;
    }
}
