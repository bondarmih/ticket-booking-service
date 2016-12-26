package com.bondarmih.ticketbooking.dto;

import com.bondarmih.ticketbooking.entity.User;

import java.io.Serializable;

/**
 * Created by bondarm on 26.12.16.
 */
public class UserDTO implements Serializable{

    private int id;
    private String name;
    private String password;

    public static UserDTO fromUser(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
