package com.bondarmih.ticketbooking.data.entity.builder;

import com.bondarmih.ticketbooking.data.dao.ISessionDAO;
import com.bondarmih.ticketbooking.data.dao.IUserDAO;
import com.bondarmih.ticketbooking.data.entity.Order;
import com.bondarmih.ticketbooking.data.entity.User;
import com.bondarmih.ticketbooking.service.SessionService;
import com.bondarmih.ticketbooking.service.UserService;
import com.bondarmih.ticketbooking.service.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by bondarm on 12.01.17.
 */
public class OrderBuilder {

    private IUserDAO userDAO;
    private ISessionDAO sessionDAO;

    public OrderBuilder(IUserDAO userDAO, ISessionDAO sessionDAO) {
        this.userDAO = userDAO;
        this.sessionDAO = sessionDAO;
    }

    public Order fromOrderDTO(OrderDTO orderDTO) {
        Order order = new Order();

        order.setDate(orderDTO.getDate());
        order.setMovieSession(sessionDAO.getSessionById(orderDTO.getSession().getId()));
        order.setUser(userDAO.getUserById(orderDTO.getUser().getId()));
        order.setRegSeats(orderDTO.isVip()? 0 : orderDTO.getTicketsCount());
        order.setVipSeats(!orderDTO.isVip()? 0 : orderDTO.getTicketsCount());
        if (orderDTO.getId() != 0) {
            order.setId(orderDTO.getId());
        }
        return order;
    }
}
