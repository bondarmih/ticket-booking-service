package com.bondarmih.ticketbooking.service.util.session;

import com.bondarmih.ticketbooking.service.dto.SessionDTO;
import com.bondarmih.ticketbooking.service.util.IParameterModifier;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by bondarm on 08.01.17.
 */
@Component
@PropertySource("classpath:application.properties")
public class PriceByTimeOfDayModifier implements IParameterModifier<SessionDTO> {

    @Value("${price.evening.multiplier}")
    private double EVENING_PRICE_MULTIPLIER;

    @Value("${price.evening.startingHour}")
    private int EVENING_HOUR;

    @Override
    public SessionDTO modify(SessionDTO input) {
        if (check(input)) {
            input.setPriceReg(Math.round(input.getPriceReg()* EVENING_PRICE_MULTIPLIER));
            input.setPriceVip(Math.round(input.getPriceVip()* EVENING_PRICE_MULTIPLIER));
        }
        return input;
    }

    @Override
    public boolean check(SessionDTO input) {
        return new DateTime(input.getTimeStart()).getHourOfDay() >= this.EVENING_HOUR;
    }


}
