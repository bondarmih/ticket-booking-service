package com.bondarmih.ticketbooking.web.controller;

import com.bondarmih.ticketbooking.service.MovieService;
import com.bondarmih.ticketbooking.service.dto.MovieDTO;
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
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @RequestMapping("/")
    public
    @ResponseBody
    List<MovieDTO> getAllMovies() {
        return movieService.getAllMovies();
    }

    @RequestMapping("/{id}")
    public @ResponseBody
    MovieDTO getMovieById(@PathVariable long id) {
        return movieService.getMovieById(id);
    }
}
