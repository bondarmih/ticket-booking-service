package com.bondarmih.ticketbooking.service.dto.builder;

import com.bondarmih.ticketbooking.data.entity.Order;
import com.bondarmih.ticketbooking.service.dto.OrderDTO;
import com.bondarmih.ticketbooking.service.dto.SessionDTO;
import com.bondarmih.ticketbooking.service.dto.UserDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by bondarm on 09.01.17.
 */
public class OrderDtoBuilder {

    public static OrderDTO getNewOrder (SessionDTO session, UserDTO user) {
        OrderDTO order = new OrderDTO();
        order.setConfirmed(false);
        order.setDate(new Date());
        order.setDiscounts(new ArrayList<String>() {
        });
        order.setSession(session);
        order.setUser(user);
        order.setTicketsCount(0);
        order.setVip(false);
        List<String> discounts = new ArrayList<>();
        order.setDiscounts(discounts);
        return order;
    }

    public static OrderDTO fromOrder(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setPrice(order.getPrice());
        orderDTO.setConfirmed(true);
        orderDTO.setSession(SessionDtoBuilder.fromSession(order.getMovieSession()));
        orderDTO.setDate(order.getDate());
        orderDTO.setVip(order.getVipSeats() > 0);
        orderDTO.setTicketsCount(orderDTO.isVip() ? order.getVipSeats() : order.getRegSeats());
        orderDTO.setUser(UserDtoBulder.fromUser(order.getUser()));
        List<String> list = new ArrayList<>();
        orderDTO.setDiscounts(list);

        return orderDTO;
    }
}
