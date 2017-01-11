package com.bondarmih.ticketbooking.web.controller;

import com.bondarmih.ticketbooking.service.OrderService;
import com.bondarmih.ticketbooking.service.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by bondarm on 04.01.17.
 */

@Controller
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("/new/{sessionId}")
    public @ResponseBody OrderDTO getOrderWithSessionId(@PathVariable int sessionId) {
        return orderService.getNewOrder(sessionId);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public @ResponseBody OrderDTO addOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.addOrder(orderDTO);
    }
}
