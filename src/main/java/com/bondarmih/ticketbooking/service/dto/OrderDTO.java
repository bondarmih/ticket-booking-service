package com.bondarmih.ticketbooking.service.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by bondarm on 04.01.17.
 */
public class OrderDTO implements Serializable{

    private long id;
    private Date date;
    private UserDTO user;
    private SessionDTO session;
    private int regTicketsCount;
    private int vipTicketsCount;
    private double price;
    private String[] discounts;
    private boolean confirmed;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public SessionDTO getSession() {
        return session;
    }

    public void setSession(SessionDTO session) {
        this.session = session;
    }

    public int getRegTicketsCount() {
        return regTicketsCount;
    }

    public void setRegTicketsCount(int regTicketsCount) {
        this.regTicketsCount = regTicketsCount;
    }

    public int getVipTicketsCount() {
        return vipTicketsCount;
    }

    public void setVipTicketsCount(int vipTicketsCount) {
        this.vipTicketsCount = vipTicketsCount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String[] getDiscounts() {
        return discounts;
    }

    public void setDiscounts(String[] discounts) {
        this.discounts = discounts;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }
}
