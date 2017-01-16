package com.bondarmih.ticketbooking.data.dao;

import com.bondarmih.ticketbooking.data.entity.Movie;

import java.util.List;

/**
 * Created by bondarm on 07.01.17.
 */
public interface IMovieDAO {

    List<Movie> getAllMovies();
    Movie getMovieById(long id);
    void saveMovie(Movie movie);
    void truncateMovies();
    void deleteMovie(Movie movie);
}
