package com.bondarmih.ticketbooking.data.dao;

import com.bondarmih.ticketbooking.data.entity.Movie;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by bondarm on 07.01.17.
 */

@Repository
@Transactional
public class MovieDAO extends AbstractHibernateDAO implements IMovieDAO {

    @Override
    @SuppressWarnings("unchecked")
    public List<Movie> getAllMovies() {
        Session session = getSession();
        List<Movie> movieList = session.createQuery("from Movie").list();
        return movieList;
    }

    @Override
    public Movie getMovieById(long id) {
        Session session = getSession();
        Movie movie = (Movie) session.get(Movie.class, id);
        return movie;
    }

    @Override
    public void saveMovie(Movie movie) {
        this.getSession().save(movie);
    }

    @Override
    public void truncateMovies() {
        Session session = getSession();
        session.createQuery("delete from Movie ").executeUpdate();
    }

    @Override
    public void deleteMovie(Movie movie) {
        this.getSession().delete(movie);
    }
}
