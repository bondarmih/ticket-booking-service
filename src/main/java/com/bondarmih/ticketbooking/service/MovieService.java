package com.bondarmih.ticketbooking.service;

import com.bondarmih.ticketbooking.data.dao.IMovieDAO;
import com.bondarmih.ticketbooking.service.dto.MovieDTO;
import com.bondarmih.ticketbooking.service.dto.builder.MovieDtoBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by bondarm on 04.01.17.
 */

@Service

public class MovieService {

    @Autowired
    IMovieDAO movieDAO;

    public List<MovieDTO> getAllMovies() {
        return movieDAO.getAllMovies()
                .stream()
                .map(MovieDtoBuilder::fromMovie)
                .collect(Collectors.toList());
    }


    public MovieDTO getMovieById(long id) {
        return MovieDtoBuilder.fromMovie(movieDAO.getMovieById(id));
    }
}
