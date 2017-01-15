package com.bondarmih.ticketbooking.service.util.session;

import com.bondarmih.ticketbooking.service.dto.SessionDTO;
import com.bondarmih.ticketbooking.service.util.IParameterModifier;
import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by bondarm on 08.01.17.
 */
@Component
@PropertySource("classpath:application.properties")
public class PriceByDayOfWeekModifier implements IParameterModifier<SessionDTO> {

    @Value("${price.weekend.multiplier}")
    private double WEEK_END_PRICE_MULTIPLIER;

    @Override
    public SessionDTO modify(SessionDTO input) {
        if (check(input)) {
            input.setPriceReg(Math.round(input.getPriceReg() * WEEK_END_PRICE_MULTIPLIER));
            input.setPriceVip(Math.round(input.getPriceVip() * WEEK_END_PRICE_MULTIPLIER));
        }
        return input;
    }

    @Override
    public boolean check(SessionDTO input) {
        return (new DateTime(input.getTimeStart()).getDayOfWeek() == DateTimeConstants.SATURDAY) ||
                (new DateTime(input.getTimeStart()).getDayOfWeek() == DateTimeConstants.SUNDAY);
    }

}
