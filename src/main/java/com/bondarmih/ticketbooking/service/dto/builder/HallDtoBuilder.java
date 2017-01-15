package com.bondarmih.ticketbooking.service.dto.builder;

import com.bondarmih.ticketbooking.data.entity.Hall;
import com.bondarmih.ticketbooking.service.dto.HallDTO;

/**
 * Created by bondarm on 15.01.17.
 */
public class HallDtoBuilder {

    public static HallDTO fromHall(Hall hall) {
        HallDTO hallDTO = new HallDTO();
        hallDTO.setId(hall.getId());
        hallDTO.setName(hall.getName());
        hallDTO.setRegularSeats(hall.getRegularSeats());
        hallDTO.setVipSeats(hall.getVipSeats());
        hallDTO.setRegMult(hall.getRegMult());
        hallDTO.setVipMult(hall.getVipMult());
        return hallDTO;
    }
}
