package com.bondarmih.ticketbooking.service.dto;

import java.io.Serializable;

/**
 * Created by bondarm on 15.01.17.
 */
public class HallDTO implements Serializable{

    private long id;
    private String name;
    private int regularSeats;
    private int vipSeats;
    private double regMult;
    private double vipMult;

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
