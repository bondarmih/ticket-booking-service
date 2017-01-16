package com.bondarmih.ticketbooking.service.dto.builder;

import com.bondarmih.ticketbooking.data.entity.Movie;
import com.bondarmih.ticketbooking.service.dto.MovieDTO;

/**
 * Created by bondarm on 07.01.17.
 */
public class MovieDtoBuilder {

    public static MovieDTO fromMovie(Movie movie) {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId(movie.getId());
        movieDTO.setName(movie.getName());
        movieDTO.setDescription(movie.getDescription());
        movieDTO.setStarting(movie.getStarting());
        movieDTO.setGenre(movie.getGenre());
        movieDTO.setDuration(movie.getDuration());
        movieDTO.setPrice(movie.getPrice());

        return movieDTO;
    }
}
