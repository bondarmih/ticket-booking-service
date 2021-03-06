package com.bondarmih.ticketbooking.service;

import com.bondarmih.ticketbooking.data.dao.IMovieDAO;
import com.bondarmih.ticketbooking.data.entity.Movie;
import com.bondarmih.ticketbooking.data.entity.builder.MovieBuilder;
import com.bondarmih.ticketbooking.service.dto.MovieDTO;
import com.bondarmih.ticketbooking.service.dto.builder.MovieDtoBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void save(MovieDTO movieDTO) {
        this.movieDAO.saveMovie(new MovieBuilder().fromMovieDto(movieDTO));
    }

    public void deleteMovieById(long id) {
        Movie movie = this.movieDAO.getMovieById(id);
        if (movie != null) {
            this.movieDAO.deleteMovie(movie);
        }
    }
}
