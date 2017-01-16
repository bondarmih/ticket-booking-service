package com.bondarmih.ticketbooking.data.dao;

import com.bondarmih.ticketbooking.data.entity.MovieSession;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by bondarm on 07.01.17.
 */

@Repository
@Transactional
public class SessionDAO extends AbstractHibernateDAO implements ISessionDAO {
    @Override
    @SuppressWarnings("unchecked")
    public List<MovieSession> getAllSessions() {
        List<MovieSession> sessionList = this.getSession().createQuery("from MovieSession").list();
        return sessionList;
    }

    @Override
    public MovieSession getSessionById(long id) {
        MovieSession session = (MovieSession) this.getSession().get(MovieSession.class, id);
        return session;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<MovieSession> getSessionsByMovieId(long id) {
        List<MovieSession> sessionList = (List<MovieSession>) this.getSession().createQuery("from MovieSession s where s.movie.Id = :id")
                .setLong("id", id).list();
        return sessionList;
    }

    @Override
    public void truncateSessions() {
        this.getSession().createQuery("delete from MovieSession ");
    }

    @Override
    public void deleteSession(MovieSession session) {
        this.getSession().delete(session);
    }

    @Override
    public void saveSession(MovieSession session){
        this.getSession().save(session);
    }
}
