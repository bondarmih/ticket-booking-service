package com.bondarmih.ticketbooking.service.dto;

import org.joda.time.DateTime;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by bondarm on 04.01.17.
 */
public class SessionDTO implements Serializable{

    private long id;
    private String hall;
    private Date timeStart;
    private MovieDTO movie;
    private double priceReg;
    private double priceVip;
    private double priceRegDiscount;
    private double priceVipDiscount;
    private int regSeatsAvailable;
    private int vipSeatsAvailable;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHall() {
        return hall;
    }

    public void setHall(String hall) {
        this.hall = hall;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    public MovieDTO getMovie() {
        return movie;
    }

    public void setMovie(MovieDTO movie) {
        this.movie = movie;
    }

    public double getPriceReg() {
        return priceReg;
    }

    public void setPriceReg(double priceReg) {
        this.priceReg = priceReg;
    }

    public double getPriceVip() {
        return priceVip;
    }

    public void setPriceVip(double priceVip) {
        this.priceVip = priceVip;
    }

    public double getPriceRegDiscount() {
        return priceRegDiscount;
    }

    public void setPriceRegDiscount(double priceRegDiscount) {
        this.priceRegDiscount = priceRegDiscount;
    }

    public double getPriceVipDiscount() {
        return priceVipDiscount;
    }

    public void setPriceVipDiscount(double priceVipDiscount) {
        this.priceVipDiscount = priceVipDiscount;
    }

    public int getRegSeatsAvailable() {
        return regSeatsAvailable;
    }

    public void setRegSeatsAvailable(int regSeatsAvailable) {
        this.regSeatsAvailable = regSeatsAvailable;
    }

    public int getVipSeatsAvailable() {
        return vipSeatsAvailable;
    }

    public void setVipSeatsAvailable(int vipSeatsAvailable) {
        this.vipSeatsAvailable = vipSeatsAvailable;
    }
}
