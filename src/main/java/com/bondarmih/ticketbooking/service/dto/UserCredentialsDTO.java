package com.bondarmih.ticketbooking.service.dto;

import com.bondarmih.ticketbooking.data.entity.User;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by bondarm on 12.01.17.
 */
public class UserCredentialsDTO implements Serializable {

    private String name;
    private String password;
    private Date dateOfBirth;

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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public User toUser() {
        User user = new User();
        user.setName(this.name);
        user.setPassword(this.password);
        user.setDateOfBirth(this.dateOfBirth);
        return user;
    }
}
