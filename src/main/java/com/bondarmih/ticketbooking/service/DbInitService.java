package com.bondarmih.ticketbooking.service;

import com.bondarmih.ticketbooking.data.dao.ISessionDAO;
import com.bondarmih.ticketbooking.data.dao.*;
import com.bondarmih.ticketbooking.data.entity.*;
import com.bondarmih.ticketbooking.data.dao.IMovieDAO;
import com.bondarmih.ticketbooking.data.dao.IHallDAO;
import com.bondarmih.ticketbooking.data.dao.IUserRoleDAO;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * Created by bondarm on 25.12.16.
 */

@Service
@Transactional
public class DbInitService {

    @Autowired
    private IUserDAO userDAO;

    @Autowired
    private IUserRoleDAO userRoleDAO;

    @Autowired
    private IHallDAO hallDAO;

    @Autowired
    private IMovieDAO movieDAO;

    @Autowired
    private ISessionDAO sessionDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void dbInit() {
        truncateAll();

        UserRole roleUser = new UserRole();
        roleUser.setName("ROLE_USER");
        userRoleDAO.addUserRole(roleUser);

        UserRole roleAdmin = new UserRole();
        roleAdmin.setName("ROLE_ADMIN");
        userRoleDAO.addUserRole(roleAdmin);

        User userAdmin = new User();
        userAdmin.setName("admin");
        String hash = this.passwordEncoder.encode("adminpass");
        userAdmin.setPassword(hash);
        userAdmin.setDateOfBirth(DateTime.parse("1986-05-06").toDate());
        Set<UserRole> roles = new HashSet<>();
        roles.add(roleAdmin);
        roles.add(roleUser);
        userAdmin.setRoles(roles);
        if (userDAO.getUserByName("admin") == null) {
            userDAO.addUser(userAdmin);
            System.out.println("admin added");
        }

        addHalls();
        addMovies();
    }

    private void truncateAll() {
//        movieDAO.truncateMovies();
//        sessionDAO.truncateSessions();
//        userDAO.truncateUsers();
//        userRoleDAO.truncateUserRoles();
//        hallDAO.truncateHalls();
    }

    private void addHalls() {
        for (int i = 1; i <= 4; i++) {
            Hall hall = new Hall();
            hall.setName("Зал №"+ i);
            hall.setRegularSeats(80 + (int)(Math.random()* 15));
            hall.setVipSeats(20 + (int)(Math.random() * 5));
            hall.setRegMult(1 + Math.random() * 0.2);
            hall.setVipMult(1.2 + Math.random() * 0.3);
            hallDAO.saveHall(hall);
        }
    }

    private void addUsers() {


    }

    private void addMovies() {
        Movie movie = new Movie();
        movie.setName("Shawshank redemption");
        movie.setGenre("genre");
        movie.setDescription("Two imprisoned men bond over a number of years, " +
                "finding solace and eventual redemption through acts of common decency.");
        movie.setDuration(142);
        movie.setPrice(300);
        movie.setStarting(DateTime.now().withYear(1994).toDate());

        List<Hall> allHalls = hallDAO.getAllHalls();

        HashSet<MovieSession> sessions = new HashSet<>();
        for (int i = 0; i < 16; i++) {
            MovieSession session = new MovieSession();
            session.setDate(DateTime.now()
                    .withMinuteOfHour(0)
                    .withSecondOfMinute(0)
                    .plusHours(1 + i * 4).toDate()
            );
            session.setHall(allHalls.get((int)(Math.random() * 4)));
            session.setMovie(movie);
            sessions.add(session);
        }
        movie.setMovieSessions(sessions);
        movieDAO.addMovie(movie);




    }
}