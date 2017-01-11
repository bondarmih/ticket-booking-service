package com.bondarmih.ticketbooking.service.util.session;

import com.bondarmih.ticketbooking.service.dto.SessionDTO;
import com.bondarmih.ticketbooking.service.util.IParameterResolver;
import org.joda.time.DateTime;

/**
 * Created by bondarm on 08.01.17.
 */
public class PriceByTimeOfDayResolver implements IParameterResolver<SessionDTO> {

    private final double EVENING_PRICE_MULTIPLIER;
    private final int EVENING_HOUR;

    public PriceByTimeOfDayResolver(double multiplier, int eveningHour) {
        this.EVENING_PRICE_MULTIPLIER = multiplier;
        this.EVENING_HOUR = eveningHour;
    }

    @Override
    public SessionDTO resolve(SessionDTO input) {
        if (check(input)) {
            input.setPriceReg(input.getPriceReg()* EVENING_PRICE_MULTIPLIER);
            input.setPriceVip(input.getPriceVip()* EVENING_PRICE_MULTIPLIER);
        }
        return input;
    }

    @Override
    public boolean check(SessionDTO input) {
        return new DateTime(input.getTimeStart()).getHourOfDay() >= this.EVENING_HOUR;
    }
}
