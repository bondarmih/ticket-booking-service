package com.bondarmih.ticketbooking.service.util;

import com.bondarmih.ticketbooking.service.dto.SessionDTO;
import com.bondarmih.ticketbooking.service.util.session.Discount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by bondarm on 08.01.17.
 */

@Component
public class SessionParametersModifier {

    @Autowired
    List<IParameterModifier<SessionDTO>> modifiers;

    public SessionDTO process(SessionDTO sessionDTO){
        for (IParameterModifier<SessionDTO> modifier: modifiers) {
            modifier.modify(sessionDTO);
        }
        return sessionDTO;
    }

    public List<String> getFixedDiscounts(boolean auth) {
        return modifiers.stream()
                .filter(Discount.class::isInstance)
                .map(Discount.class::cast)
                .filter((Discount d) -> (!auth && !d.isForAuth()) || auth )
                .map(Discount::getDescription)
                .collect(Collectors.toList());
    }
}
