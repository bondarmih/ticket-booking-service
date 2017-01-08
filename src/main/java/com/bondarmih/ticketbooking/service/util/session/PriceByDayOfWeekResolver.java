package com.bondarmih.ticketbooking.service.util.session;

import com.bondarmih.ticketbooking.service.dto.SessionDTO;
import com.bondarmih.ticketbooking.service.util.IParameterResolver;
import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by bondarm on 08.01.17.
 */

public class PriceByDayOfWeekResolver implements IParameterResolver<SessionDTO> {

    private final double WEEK_END_PRICE_MULTIPLIER;

    public PriceByDayOfWeekResolver(double multiplier) {
        this.WEEK_END_PRICE_MULTIPLIER = multiplier;
    }

    @Override
    public SessionDTO resolve(SessionDTO input) {
        if (check(input)) {
            input.setPriceReg(input.getPriceReg() * WEEK_END_PRICE_MULTIPLIER);
            input.setPriceVip(input.getPriceVip() * WEEK_END_PRICE_MULTIPLIER);
        }
        return input;
    }

    @Override
    public boolean check(SessionDTO input) {
        return (new DateTime(input.getTimeStart()).getDayOfWeek() == DateTimeConstants.SATURDAY) ||
                (new DateTime(input.getTimeStart()).getDayOfWeek() == DateTimeConstants.SUNDAY);
    }

}
