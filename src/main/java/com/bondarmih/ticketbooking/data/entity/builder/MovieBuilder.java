package com.bondarmih.ticketbooking.data.entity.builder;

import com.bondarmih.ticketbooking.data.entity.Movie;
import com.bondarmih.ticketbooking.data.entity.MovieSession;
import com.bondarmih.ticketbooking.service.dto.MovieDTO;

import java.util.Date;
import java.util.Set;

/**
 * Created by bondarm on 16.01.17.
 */
public class MovieBuilder {

    private long id;
    private String name;
    private String description;
    private Date starting;
    private String genre;
    private int duration;
    private int price;
    private Set<MovieSession> sessions;

    public Movie fromMovieDto(MovieDTO movieDTO) {
        return this.withId(movieDTO.getId())
                .withName(movieDTO.getName())
                .withDescription(movieDTO.getDescription())
                .withStarting(movieDTO.getStarting())
                .withGenre(movieDTO.getGenre())
                .withDuration(movieDTO.getDuration())
                .withPrice(movieDTO.getPrice())
                .build();
    }

    public MovieBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public MovieBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public MovieBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public MovieBuilder withStarting(Date starting) {
        this.starting = starting;
        return this;
    }

    public MovieBuilder withGenre(String genre) {
        this.genre = genre;
        return this;
    }

    public MovieBuilder withDuration(int duration) {
        this.duration = duration;
        return this;
    }

    public MovieBuilder withPrice(int price) {
        this.price = price;
        return this;
    }

    public MovieBuilder withSessions(Set<MovieSession> sessions) {
        this.sessions = sessions;
        return  this;
    }

    public Movie build() {
        Movie movie = new Movie();
        movie.setId(this.id);
        movie.setName(this.name);
        movie.setDescription(this.description);
        movie.setStarting(this.starting);
        movie.setGenre(this.genre);
        movie.setDuration(this.duration);
        movie.setPrice(this.price);
        movie.setMovieSessions(this.sessions);
        return movie;
    }




}
