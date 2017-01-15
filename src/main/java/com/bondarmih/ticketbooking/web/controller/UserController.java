package com.bondarmih.ticketbooking.web.controller;

import com.bondarmih.ticketbooking.service.UserService;
import com.bondarmih.ticketbooking.service.dto.UserCredentialsDTO;
import com.bondarmih.ticketbooking.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/getCurrentUser")
    public @ResponseBody
    UserDTO whoAmI(Authentication authentication) {
        if ((authentication != null) && !(authentication instanceof AnonymousAuthenticationToken)) {
            UserDTO user = userService.findUserByName(authentication.getName());
            return user;
        }
        return null;
    }

    @RequestMapping(value = "/{userId}")
    public @ResponseBody
    UserDTO getUser(@PathVariable long userId) {
        return userService.getUserDTOById(userId);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void addUser(@RequestBody UserCredentialsDTO userCreds) {
        userService.addUser(userCreds.getName(), userCreds.getPassword(), userCreds.getDateOfBirth());
    }

    @RequestMapping(value = "/byName/{userName}")
    public @ResponseBody UserDTO getUserByName(@PathVariable String userName) {
        UserDTO user = userService.findUserByName(userName);
        return user;
    }

    @RequestMapping(value = "/discounts")
    public @ResponseBody List<String> getDiscounts() {
        return userService.getDiscounts();
    }
}
