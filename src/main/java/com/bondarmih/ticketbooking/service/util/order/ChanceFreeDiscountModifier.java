package com.bondarmih.ticketbooking.service.util.order;

import com.bondarmih.ticketbooking.service.dto.OrderDTO;
import com.bondarmih.ticketbooking.service.util.IParameterModifier;
import com.bondarmih.ticketbooking.service.util.session.Discount;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by bondarm on 14.01.17.
 */

@Component
@PropertySource("classpath:application.properties")
public class ChanceFreeDiscountModifier implements IParameterModifier<OrderDTO>, Discount {

    @Value("${discount.freeTicket.probability}")
    private double CHANCE;

    @Override
    public String getDescription() {
        return "С вероятностью " + (int)(this.CHANCE*100) + "% один билет в заказе - бесплатно";
    }

    @Override
    public OrderDTO modify(OrderDTO input) {
        double roulette = Math.random();
        if (roulette < CHANCE) {
            double totalPrice = input.getPrice();
            double ticketPrice = (input.isVip() ?
                    (input.getSession().getPriceVipDiscount() > 0 ?
                            input.getSession().getPriceVipDiscount() :
                            input.getSession().getPriceVip()) :
                    (input.getSession().getPriceRegDiscount() > 0 ?
                            input.getSession().getPriceRegDiscount() :
                            input.getSession().getPriceReg()));
            totalPrice -= (ticketPrice);
            input.setPrice(totalPrice);
            input.getDiscounts().add(getDescription());
        }
            return input;
    }

    @Override
    public boolean isForAuth() {
        return false;
    }

    @Override
    public boolean check(OrderDTO input) {
        return true;
    }

    @Override
    public boolean isFixed() {
        return false;
    }
}
