package com.bondarmih.ticketbooking.data.dao;

import com.bondarmih.ticketbooking.data.entity.MovieSession;

import java.util.List;

/**
 * Created by bondarm on 07.01.17.
 */
public interface ISessionDAO {

    List<MovieSession> getAllSessions();
    MovieSession getSessionById(long id);
    List<MovieSession> getSessionsByMovieId(long id);
    void truncateSessions();
    void deleteSession(MovieSession session);
    void saveSession(MovieSession session);

}
