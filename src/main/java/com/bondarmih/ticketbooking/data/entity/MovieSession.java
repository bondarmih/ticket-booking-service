package com.bondarmih.ticketbooking.data.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by bondarm on 22.12.16.
 */

@Entity
@Table(name = "moviesession")
public class MovieSession {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long id;

    @ManyToOne
    private Movie movie;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    private Hall hall;

    @OneToMany(mappedBy = "movieSession")
    private Set<Ticket> tickets;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }
}
