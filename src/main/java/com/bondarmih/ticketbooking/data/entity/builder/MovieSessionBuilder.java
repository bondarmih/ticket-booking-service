package com.bondarmih.ticketbooking.data.entity.builder;

import com.bondarmih.ticketbooking.data.entity.Hall;
import com.bondarmih.ticketbooking.data.entity.Movie;
import com.bondarmih.ticketbooking.data.entity.MovieSession;
import com.bondarmih.ticketbooking.service.dto.SessionDTO;

import java.util.Date;

/**
 * Created by bondarm on 12.01.17.
 */
public class MovieSessionBuilder {
    public static MovieSession fromSessionDTO(SessionDTO session) {

        MovieSession movieSession = new MovieSession();

        movieSession.setId(session.getId());
        return movieSession;

    }

    private long id;
    private Movie movie;
    private Date date;
    private Hall hall;

}
