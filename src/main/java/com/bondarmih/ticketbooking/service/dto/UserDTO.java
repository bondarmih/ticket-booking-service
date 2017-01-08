package com.bondarmih.ticketbooking.service.dto;

import com.bondarmih.ticketbooking.data.entity.User;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by bondarm on 26.12.16.
 */
public class UserDTO implements Serializable {

    private long id;
    private String name;
    private Date dateOfBirth;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
