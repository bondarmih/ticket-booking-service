package com.bondarmih.ticketbooking.service.util.session;

import com.bondarmih.ticketbooking.service.UserService;
import com.bondarmih.ticketbooking.service.dto.SessionDTO;
import com.bondarmih.ticketbooking.service.dto.UserDTO;
import com.bondarmih.ticketbooking.service.util.IParameterModifier;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by bondarm on 13.01.17.
 */
@Component
@PropertySource("classpath:application.properties")
public class PriceByAgeDiscountModifier implements IParameterModifier<SessionDTO>, Discount {

    @Value("${discount.byAge.multiplier}")
    private double MULTIPLIER;

    @Value("${discount.byAge.age}")
    private int AGE;

    @Autowired
    UserService userService;

    @Override
    public String getDescription() {
        return "Детям до " + this.AGE + " лет - скидка " + (100-MULTIPLIER*100) +
                "% (только для авторизованных пользователей)";
    }

    @Override
    public SessionDTO modify(SessionDTO input) {
        if (!check(input)) {
            return input;
        }
        double priceReg;
        double priceVip;

        if(input.getPriceRegDiscount() > 0) {
            priceReg = input.getPriceRegDiscount();
        } else {
            priceReg = input.getPriceReg();
        }
        if(input.getPriceVipDiscount() > 0) {
            priceVip = input.getPriceVipDiscount();
        } else {
            priceVip = input.getPriceVip();
        }

        input.setPriceRegDiscount(Math.round(priceReg * MULTIPLIER));
        input.setPriceVipDiscount(Math.round(priceVip * MULTIPLIER));
        input.getDiscounts().add(getDescription());
        return input;
    }

    @Override
    public final boolean isForAuth() {
        return true;
    }

    @Override
    public boolean check(SessionDTO input) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String userName = authentication.getName();
            UserDTO user = userService.findUserByName(userName);
            return (new DateTime(user.getDateOfBirth()).plusYears(AGE).isAfter(new Date().getTime()));
        } else
            return false;
    }

    @Override
    public final boolean isFixed() {
        return true;
    }
}
