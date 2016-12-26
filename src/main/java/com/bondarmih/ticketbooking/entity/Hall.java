package com.bondarmih.ticketbooking.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by bondarm on 22.12.16.
 */

@Entity
@Table(name = "hall")
public class Hall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "regular_seats")
    private int regularSeats;

    @Column(name = "vip_seats")
    private  int vipSeats;

    @OneToMany(mappedBy = "hall")
    private Set<MovieSession> movieSessions;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRegularSeats() {
        return regularSeats;
    }

    public void setRegularSeats(int regularSeats) {
        this.regularSeats = regularSeats;
    }

    public int getVipSeats() {
        return vipSeats;
    }

    public void setVipSeats(int vipSeats) {
        this.vipSeats = vipSeats;
    }

    public Set<MovieSession> getMovieSessions() {
        return movieSessions;
    }

    public void setMovieSessions(Set<MovieSession> movieSessions) {
        this.movieSessions = movieSessions;
    }
}
