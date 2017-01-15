package com.bondarmih.ticketbooking.data.entity;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Set;

/**
 * Created by bondarm on 22.12.16.
 */

@Entity
@Table(name = "hall")
public class Hall {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "regular_seats")
    private int regularSeats;

    @Column(name = "vip_seats")
    private  int vipSeats;

    @Column(name = "regulag_multiplier")
    private double regMult;

    @Column(name = "vip_multiplier")
    private double vipMult;

    @OneToMany(mappedBy = "hall")
    @Cascade(value = CascadeType.DELETE)
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

    public double getRegMult() {
        return regMult;
    }

    public void setRegMult(double regMult) {
        this.regMult = regMult;
    }

    public double getVipMult() {
        return vipMult;
    }

    public void setVipMult(double vipMult) {
        this.vipMult = vipMult;
    }
}
