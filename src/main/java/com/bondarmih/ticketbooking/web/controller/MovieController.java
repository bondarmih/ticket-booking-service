package com.bondarmih.ticketbooking.web.controller;

import com.bondarmih.ticketbooking.service.MovieService;
import com.bondarmih.ticketbooking.service.dto.MovieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by bondarm on 08.01.17.
 */
@Controller
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody
    List<MovieDTO> getAllMovies() {
        return movieService.getAllMovies();
    }

    @RequestMapping("/{id}")
    public @ResponseBody
    MovieDTO getMovieById(@PathVariable long id) {
        return movieService.getMovieById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void saveMovie(@RequestBody MovieDTO movieDTO) {
        this.movieService.save(movieDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteMovie(@PathVariable long id) {
        this.movieService.deleteMovieById(id);
    }
}
