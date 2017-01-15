package com.bondarmih.ticketbooking.service;

import com.bondarmih.ticketbooking.data.dao.IOrderDAO;
import com.bondarmih.ticketbooking.data.dao.ISessionDAO;
import com.bondarmih.ticketbooking.data.dao.IUserDAO;
import com.bondarmih.ticketbooking.data.entity.Order;
import com.bondarmih.ticketbooking.data.entity.builder.OrderBuilder;
import com.bondarmih.ticketbooking.service.dto.OrderDTO;
import com.bondarmih.ticketbooking.service.dto.SessionDTO;
import com.bondarmih.ticketbooking.service.dto.UserDTO;
import com.bondarmih.ticketbooking.service.dto.builder.OrderDtoBuilder;
import com.bondarmih.ticketbooking.service.dto.builder.UserDtoBulder;
import com.bondarmih.ticketbooking.service.util.OrderParameterModifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by bondarm on 07.01.17.
 */

@Service
public class OrderService {

    @Autowired
    IOrderDAO orderDAO;

    @Autowired
    SessionService sessionService;

    @Autowired
    UserService userService;

    @Autowired
    ISessionDAO sessionDAO;

    @Autowired
    IUserDAO userDAO;

    @Autowired
    OrderParameterModifier orderParameterModifier;

    public OrderDTO getNewOrder(int sessionId) {
        SessionDTO session = sessionService.getSessionById(sessionId);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String userName = authentication.getName();
            UserDTO user = userService.findUserByName(userName);
            return OrderDtoBuilder.getNewOrder(session, user);

        } else {
            UserDTO user = UserDtoBulder.anonymousUser();
            return OrderDtoBuilder.getNewOrder(session, user);
        }
    }

    public OrderDTO addOrder(OrderDTO orderDTO) {
        orderDTO = orderParameterModifier.process(orderDTO);
        Order order = new OrderBuilder(userDAO, sessionDAO).fromOrderDTO(orderDTO);
        long id = orderDAO.addOrder(order);
        orderDTO.setId(id);
        orderDTO.setConfirmed(true);
        return orderDTO;
    }

    public long getTicketsCountByUser(UserDTO userDTO) {
        return orderDAO.getTicketsCountByUser(userDTO.getId());
    }

    public List<OrderDTO> getOrdersByUserId(long userId) {
        return orderDAO.getOrdersByUserId(userId)
                .stream()
                .map(OrderDtoBuilder::fromOrder)
                .collect(Collectors.toList());
    }
}
