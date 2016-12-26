package com.bondarmih.ticketbooking.service;

import com.bondarmih.ticketbooking.dao.IUserDAO;
import com.bondarmih.ticketbooking.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by bondarm on 25.12.16.
 */

@Service
@Transactional
public class DbInitService {

    @Autowired
    IUserDAO userDAO;

    @PostConstruct
    public void dbInit() {

        userDAO.truncateUsers();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setDateOfBirth(new GregorianCalendar(2000, 01, i).getTime());
            user.setName("User"+i);
            user.setPassword("password"+i);
            userDAO.addUser(user);
        }
    }
}
