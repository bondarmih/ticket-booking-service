package com.bondarmih.ticketbooking.service.util.order;

import com.bondarmih.ticketbooking.service.OrderService;
import com.bondarmih.ticketbooking.service.UserService;
import com.bondarmih.ticketbooking.service.dto.OrderDTO;
import com.bondarmih.ticketbooking.service.dto.UserDTO;
import com.bondarmih.ticketbooking.service.util.IParameterModifier;
import com.bondarmih.ticketbooking.service.util.session.Discount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Created by bondarm on 13.01.17.
 */

@Component
@PropertySource("classpath:application.properties")
public class EveryTenthFreeDiscountModifier implements IParameterModifier<OrderDTO>, Discount {

    @Value("${discount.everyNthTicketFreeForAuth.count}")
    private int COUNT;

    @Autowired
    UserService userService;

    @Autowired
    OrderService orderService;

    @Override
    public String getDescription() {
        return "Каждый " + this.COUNT + "-й билет - бесплатно (только для авторизованных пользователей)";
    }

    @Override
    public OrderDTO modify(OrderDTO input) {
        if (this.check(input)) {
            UserDTO user = userService.getUserDTOById(input.getUser().getId());
            long freeTicketsCount = checkTicketsCount(user, input);
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
    public boolean isForAuth() {
        return true;
    }

    @Override
    public boolean check(OrderDTO input) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String userName = authentication.getName();
            UserDTO user = userService.findUserByName(userName);
            return (this.checkTicketsCount(user, input) > 0);
        } else
            return false;
    }

    private long checkTicketsCount(UserDTO user, OrderDTO order) {
        long ticketsCount = this.orderService.getTicketsCountByUser(user);
        return (ticketsCount + order.getTicketsCount())/COUNT - ticketsCount/COUNT;
    }

    @Override
    public boolean isFixed() {
        return false;
    }
}
