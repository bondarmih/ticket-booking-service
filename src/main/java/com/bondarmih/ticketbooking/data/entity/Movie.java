package com.bondarmih.ticketbooking.data.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by bondarm on 22.12.16.
 */

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long Id;

    @Column(name = "name")
    private String name;

    @Column(name = "duration")
    private int duration;

    @Column(name = "price")
    private int price;

    @OneToMany(mappedBy = "movie")
    private Set<MovieSession> movieSessions;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Set<MovieSession> getMovieSessions() {
        return movieSessions;
    }

    public void setMovieSessions(Set<MovieSession> movieSessions) {
        this.movieSessions = movieSessions;
    }
}
