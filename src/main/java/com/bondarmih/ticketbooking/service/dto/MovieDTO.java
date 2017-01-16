package com.bondarmih.ticketbooking.service.dto;

import org.joda.time.DateTime;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by bondarm on 04.01.17.
 */
public class MovieDTO implements Serializable{

    private long id;
    private String name;
    private String description;
    private Date starting;
    private String genre;
    private int duration;
    private int price;
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStarting() {
        return starting;
    }

    public void setStarting(Date starting) {
        this.starting = starting;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
