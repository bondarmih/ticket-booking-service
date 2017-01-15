package com.bondarmih.ticketbooking.service;

import com.bondarmih.ticketbooking.data.dao.IUserDAO;
import com.bondarmih.ticketbooking.data.entity.User;
import com.bondarmih.ticketbooking.service.dto.UserDTO;
import com.bondarmih.ticketbooking.service.dto.builder.UserDtoBulder;
import com.bondarmih.ticketbooking.service.util.OrderParameterModifier;
import com.bondarmih.ticketbooking.service.util.SessionParametersModifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by bondarm on 22.12.16.
 */

@Service
public class UserService {

    @Autowired
    IUserDAO userDAO;

    @Autowired
    SessionParametersModifier sessionParametersModifier;

    @Autowired
    OrderParameterModifier orderParametersResolver;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserDTO findUserByName(String name) {
        UserDTO user = UserDtoBulder.fromUser(userDAO.getUserByName(name));
        if (user == null) {
            user = new UserDTO();
            user.setName(null);
        }
        return user;
    }

    public List<UserDTO> getAllUsers() {
        return userDAO.getAllUsers()
                .stream()
                .map(UserDtoBulder::fromUser)
                .collect(Collectors.toList());
    }

    public UserDTO getUserDTOById(long id) {
        return UserDtoBulder.fromUser(userDAO.getUserById(id));
    }

    public List<String> getDiscounts() {

        List<String> discountList = new ArrayList<>();
        discountList.addAll(sessionParametersModifier.getFixedDiscounts(this.isAuthenticated()));
        discountList.addAll(orderParametersResolver.getRandomDiscounts(this.isAuthenticated()));
        return discountList;
    }

    private boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (!(authentication instanceof AnonymousAuthenticationToken));
    }

    public User getUserById(long id) {
        return userDAO.getUserById(id);
    }


    public void addUser(String name, String password, Date dateOfBirth) {
        User user = new User();
        user.setName(name);
        user.setPassword(passwordEncoder.encode(password));
        user.setDateOfBirth(dateOfBirth);
        userDAO.addUser(user);
    }
}
