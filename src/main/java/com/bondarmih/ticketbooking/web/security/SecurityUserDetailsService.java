package com.bondarmih.ticketbooking.web.security;

import com.bondarmih.ticketbooking.data.dao.IUserDAO;
import com.bondarmih.ticketbooking.data.entity.User;
import com.bondarmih.ticketbooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Created by bondarm on 14.08.16.
 */

@Component
public class SecurityUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userDAO.getUserByName(name);
        if (user == null) {
            throw new UsernameNotFoundException("UserName "+name+" not found");
        }
        return new SecurityUserDetails(user);
    }
}
