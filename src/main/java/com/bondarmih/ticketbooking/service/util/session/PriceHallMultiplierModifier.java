package com.bondarmih.ticketbooking.service.util.session;

import com.bondarmih.ticketbooking.service.dto.SessionDTO;
import com.bondarmih.ticketbooking.service.util.IParameterModifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by bondarm on 08.01.17.
 */
@Component
@Order(1)
public class PriceHallMultiplierModifier implements IParameterModifier<SessionDTO> {

    @Override
    public SessionDTO modify(SessionDTO input) {
        input.setPriceReg(Math.round(input.getPriceReg() * input.getHall().getRegMult()));
        input.setPriceVip(Math.round(input.getPriceVip() * input.getHall().getVipMult()));
        return input;
    }

    @Override
    public boolean check(SessionDTO input) {
        return true;
    }


}
