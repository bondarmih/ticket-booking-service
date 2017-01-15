package com.bondarmih.ticketbooking.service.dto.builder;

import com.bondarmih.ticketbooking.data.entity.MovieSession;
import com.bondarmih.ticketbooking.data.entity.Order;
import com.bondarmih.ticketbooking.service.dto.SessionDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by bondarm on 07.01.17.
 */
public class SessionDtoBuilder {
    public static SessionDTO fromSession(MovieSession session) {
        SessionDTO sessionDTO = new SessionDTO();
        sessionDTO.setId(session.getId());
        sessionDTO.setHall(HallDtoBuilder.fromHall(session.getHall()));
        sessionDTO.setTimeStart(session.getDate());
        sessionDTO.setMovie(MovieDtoBuilder.fromMovie(session.getMovie()));
        sessionDTO.setPriceReg(session.getMovie().getPrice());
        sessionDTO.setPriceVip(session.getMovie().getPrice());
        sessionDTO.setPriceRegDiscount(0);
        sessionDTO.setPriceVipDiscount(0);
        sessionDTO.setRegSeatsAvailable(session
                .getHall()
                .getRegularSeats() - getAvailableRegSeats(session.getOrders()));
        sessionDTO.setVipSeatsAvailable(session
                .getHall()
                .getVipSeats() - getAvailableVipSeats(session.getOrders()));
        List<String> discounts = new ArrayList<>();
        sessionDTO.setDiscounts(discounts);
        return sessionDTO;
    }

    private static int getAvailableRegSeats(Set<Order> orders) {
        if (orders.size() == 0) {
            return 0;
        }

        return orders.stream()
                .mapToInt(Order::getRegSeats)
                .sum();
    }

    private static int getAvailableVipSeats(Set<Order> orders) {
        if (orders.size() == 0) {
            return 0;
        }
        return orders.stream()
                .mapToInt(Order::getVipSeats)
                .sum();
    }

}
