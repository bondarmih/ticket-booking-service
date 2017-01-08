package com.bondarmih.ticketbooking.web.controller;

import com.bondarmih.ticketbooking.service.SessionService;
import com.bondarmih.ticketbooking.service.dto.SessionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by bondarm on 08.01.17.
 */

@Controller
@RequestMapping("/sessions")
public class SessionController {

    @Autowired
    SessionService sessionService;

    @RequestMapping("/{id}")
    public @ResponseBody
    SessionDTO getSessionById(@PathVariable long id) {
        return sessionService.getSessionById(id);
    }

    @RequestMapping("/byMovieId/{movieId}")
    public @ResponseBody
    List<SessionDTO> getSessionsByMovieId(@PathVariable long movieId) {
        return sessionService.getSessionsByMovieId(movieId);
    }

}
