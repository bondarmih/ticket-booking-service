package com.bondarmih.ticketbooking.dao;

import com.bondarmih.ticketbooking.entity.User;

import java.util.List;

/**
 * Created by bondarm on 25.12.16.
 */
public interface IUserDAO {

    List<User> getAllUsers();
    User getUserById(long id);
    User getUserByName(String name);
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(long id);
    public void truncateUsers();

}
