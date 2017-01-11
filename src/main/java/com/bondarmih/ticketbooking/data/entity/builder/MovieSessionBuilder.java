package com.bondarmih.ticketbooking.data.entity.builder;

import com.bondarmih.ticketbooking.data.entity.MovieSession;
import com.bondarmih.ticketbooking.service.dto.SessionDTO;

/**
 * Created by bondarm on 12.01.17.
 */
public class MovieSessionBuilder {
    public static MovieSession fromSessionDTO(SessionDTO session) {

        MovieSession movieSession = new MovieSession();

        movieSession.setId(session.getId());
        return movieSession;

    }
}
