package com.bondarmih.ticketbooking.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by bondarm on 22.12.16.
 */
@Controller
@RequestMapping({"/","/movies/**", "/sessions/**", "/orders/**", "/users/**"})
public class IndexController {

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "/index.html";
    }


}
