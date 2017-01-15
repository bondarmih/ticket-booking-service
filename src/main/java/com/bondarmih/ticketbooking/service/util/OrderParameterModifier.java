package com.bondarmih.ticketbooking.service.util;

import com.bondarmih.ticketbooking.service.dto.OrderDTO;
import com.bondarmih.ticketbooking.service.util.session.Discount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by bondarm on 13.01.17.
 */

@Component
public class OrderParameterModifier {

    @Autowired
    List<IParameterModifier<OrderDTO>> modifiers;

    public List<String> getRandomDiscounts(boolean auth) {
        return modifiers.stream()
                .filter(Discount.class::isInstance)
                .map(Discount.class::cast)
                .filter((Discount d) -> ((!auth && !d.isForAuth()) || auth ))
                .map(Discount::getDescription)
                .collect(Collectors.toList());
    }

    public OrderDTO process(OrderDTO orderDTO){
        for (IParameterModifier<OrderDTO> modifier: modifiers) {
            modifier.modify(orderDTO);
        }
        return orderDTO;
    }
}
