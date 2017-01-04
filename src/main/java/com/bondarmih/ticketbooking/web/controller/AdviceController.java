package com.bondarmih.ticketbooking.web.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * Created by bondarm on 03.01.17.
 */
@ControllerAdvice
public class AdviceController {

    @ExceptionHandler(NoHandlerFoundException.class)
    public String handle(Exception ex) {
        return "redirect:/index.html";
    }

}