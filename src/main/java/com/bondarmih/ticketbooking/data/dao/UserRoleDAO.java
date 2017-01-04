package com.bondarmih.ticketbooking.data.dao;

import com.bondarmih.ticketbooking.data.entity.UserRole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by bondarm on 03.01.17.
 */

@Repository
@Transactional
public class UserRoleDAO implements IUserRoleDAO {

    @Autowired
    SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    public List<UserRole> getAllUserRoles() {
        Session session = getSession();
        List<UserRole> userRoleList = session.createQuery("from UserRole").list();
        return userRoleList;
    }

    @Override
    public UserRole getUserRoleById(long id) {
        Session session = getSession();
        UserRole userRole = (UserRole) session.load(UserRole.class, id);
        return userRole;
    }

    @Override
    public UserRole getUserRoleByName(String name) {
        Session session = getSession();
        UserRole userRole = (UserRole) session.load(UserRole.class, name);
        return userRole;
    }

    @Override
    public void addUserRole(UserRole userRole) {
        Session session = getSession();
        session.persist(userRole);
    }

    public void truncateUserRoles() {
        Session session = getSession();
        session.createQuery("delete from UserRole ").executeUpdate();
    }
}
