package com.bondarmih.ticketbooking.data.entity.builder;

import com.bondarmih.ticketbooking.data.entity.Hall;
import com.bondarmih.ticketbooking.service.dto.HallDTO;

/**
 * Created by bondarm on 15.01.17.
 */
public class HallBuilder {

    private long id;
    private String name;
    private int regularSeats;
    private int vipSeats;
    private double regMult;
    private double vipMult;

    public Hall fromHallDto(HallDTO hallDTO) {
        return this.withId(hallDTO.getId())
                .withName(hallDTO.getName())
                .withRegularSeats(hallDTO.getRegularSeats())
                .withVipSeats(hallDTO.getVipSeats())
                .withRegMult(hallDTO.getRegMult())
                .withVipMult(hallDTO.getVipMult())
                .build();
    }

    public HallBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public HallBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public HallBuilder withRegularSeats(int regularSeats) {
        this.regularSeats = regularSeats;
        return this;
    }

    public HallBuilder withVipSeats(int vipSeats) {
        this.vipSeats = vipSeats;
        return this;
    }

    public HallBuilder withRegMult(double regMult) {
        this.regMult = regMult;
        return this;
    }

    public HallBuilder withVipMult(double vipMult) {
        this.vipMult = vipMult;
        return this;
    }

    public Hall build() {
        Hall hall = new Hall();
        hall.setId(this.id);
        hall.setName(this.name);
        hall.setRegularSeats(this.regularSeats);
        hall.setVipSeats(this.vipSeats);
        hall.setRegMult(this.regMult);
        hall.setVipMult(this.vipMult);
        return hall;
    }


}
