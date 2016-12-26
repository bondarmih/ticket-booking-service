package com.bondarmih.ticketbooking.controller;

import com.bondarmih.ticketbooking.dto.UserDTO;
import com.bondarmih.ticketbooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

/**
 * Created by bondarm on 22.12.16.
 */

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/all")
    public @ResponseBody List<UserDTO> allUsers() {
        List<UserDTO> users = userService.getAllUsers();
        return users;
    }

}
