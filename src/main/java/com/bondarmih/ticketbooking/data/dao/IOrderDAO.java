package com.bondarmih.ticketbooking.data.dao;

import com.bondarmih.ticketbooking.data.entity.Order;
import com.bondarmih.ticketbooking.data.entity.User;

import java.util.List;

/**
 * Created by bondarm on 08.01.17.
 */
public interface IOrderDAO {

    List<Order> getAllOrders();
    List<Order> getOrdersByUserId(long userId);
    List<Order> getOrdersBySessionId(long sessionId);
    int getBookedRegSeatsCount(long sessionId);
    int getBookedVipSeatsCount(long sessionId);
    long addOrder(Order order);
    void truncateOrders();

    long getTicketsCountByUser(long userId);
}
