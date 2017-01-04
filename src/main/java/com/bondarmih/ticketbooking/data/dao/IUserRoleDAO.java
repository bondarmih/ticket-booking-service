package com.bondarmih.ticketbooking.data.dao;

import com.bondarmih.ticketbooking.data.entity.UserRole;

import java.util.List;

/**
 * Created by bondarm on 03.01.17.
 */
public interface IUserRoleDAO {

    List<UserRole> getAllUserRoles();
    UserRole getUserRoleById(long id);
    UserRole getUserRoleByName(String name);
    void addUserRole(UserRole userRole);
    public void truncateUserRoles();
}
