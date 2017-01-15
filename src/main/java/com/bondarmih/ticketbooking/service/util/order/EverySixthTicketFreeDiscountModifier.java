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
public class EverySixthTicketFreeDiscountModifier implements IParameterModifier<OrderDTO>, Discount {

    @Value("${discount.everyNthTicketInOrderFree.count}")
    private int COUNT;

    @Override
    public String getDescription() {
        return "Каждый " + this.COUNT + "-й билет в заказе - бесплатно";
    }

    @Override
    public boolean isForAuth() {
        return false;
    }

    @Override
    public boolean isFixed() {
        return false;
    }

    @Override
    public OrderDTO modify(OrderDTO input) {
        int freeTicketsCount = input.getTicketsCount()/COUNT;
        if (freeTicketsCount > 0) {
            double totalPrice = input.getPrice();
            double ticketPrice = (input.isVip() ?
                    (input.getSession().getPriceVipDiscount() > 0 ?
                            input.getSession().getPriceVipDiscount() :
                            input.getSession().getPriceVip()) :
                    (input.getSession().getPriceRegDiscount() > 0 ?
                            input.getSession().getPriceRegDiscount() :
                            input.getSession().getPriceReg()));
            totalPrice -= (freeTicketsCount * ticketPrice);
            input.setPrice(totalPrice);
            input.getDiscounts().add(getDescription());
        }
        return input;
    }

    @Override
    public boolean check(OrderDTO input) {
        return true;
    }
}
