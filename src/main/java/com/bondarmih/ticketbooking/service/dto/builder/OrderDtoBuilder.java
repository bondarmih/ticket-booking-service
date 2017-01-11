package com.bondarmih.ticketbooking.service.dto.builder;

import com.bondarmih.ticketbooking.service.dto.OrderDTO;
import com.bondarmih.ticketbooking.service.dto.SessionDTO;
import com.bondarmih.ticketbooking.service.dto.UserDTO;

import java.util.Date;

/**
 * Created by bondarm on 09.01.17.
 */
public class OrderDtoBuilder {

    public static OrderDTO getNewOrder (SessionDTO session, UserDTO user) {
        OrderDTO order = new OrderDTO();
        order.setConfirmed(false);
        order.setDate(new Date());
        order.setDiscounts(new String[]{});
        order.setSession(session);
        order.setUser(user);
        order.setTicketsCount(0);
        order.setVip(false);
        return order;
    }
}
