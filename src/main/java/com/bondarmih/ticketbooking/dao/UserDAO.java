package com.bondarmih.ticketbooking.dao;

import com.bondarmih.ticketbooking.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by bondarm on 25.12.16.
 */

@Repository
@Transactional
public class UserDAO implements IUserDAO {

    @Autowired
    SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        Session session = getSession();
        List<User> userList = session.createQuery("from User").list();
        return userList;
    }

    @Override
    public User getUserById(long id) {
        Session session = getSession();
        User user = (User) session.load(User.class, id);
        return user;
    }

    @Override
    public User getUserByName(String name) {
        Session session = getSession();
        User user = (User) session.load(User.class, name);
        return user;
    }

    @Override
    public void addUser(User user) {
        Session session = getSession();
        session.persist(user);
    }

    @Override
    public void updateUser(User user) {
        Session session = getSession();
        session.update(user);
    }

    @Override
    public void deleteUser(long id) {
        Session session = getSession();
        User user = (User) session.load(User.class, id);
        if (user != null) {
            session.delete(user);
        }
    }

    public void truncateUsers() {
        Session session = getSession();
        session.createQuery("delete from User").executeUpdate();
    }
}
