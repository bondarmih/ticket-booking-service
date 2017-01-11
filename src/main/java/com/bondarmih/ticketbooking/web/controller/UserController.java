package com.bondarmih.ticketbooking.web.controller;

import com.bondarmih.ticketbooking.data.entity.User;
import com.bondarmih.ticketbooking.service.UserService;
import com.bondarmih.ticketbooking.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.security.Principal;
import java.util.List;

/**
 * Created by bondarm on 22.12.16.
 */

@Controller
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/")
    public @ResponseBody
    List<UserDTO> allUsers() {
        List<UserDTO> users = userService.getAllUsers();
        return users;
    }

    @RequestMapping(value = "/getUserName")
    public @ResponseBody
    UserDTO whoAmI(Authentication authentication) {
        UserDTO user = userService.findUserByName(authentication.getName());
        return user;
    }

    @RequestMapping(value = "/{userId}")
    public @ResponseBody
    UserDTO getUser(@PathVariable long id) {
        return userService.getUserById(id);
    }

}
