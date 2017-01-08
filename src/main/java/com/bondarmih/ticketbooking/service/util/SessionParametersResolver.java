package com.bondarmih.ticketbooking.service.util;

import com.bondarmih.ticketbooking.service.dto.SessionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by bondarm on 08.01.17.
 */

@Component
public class SessionParametersResolver {

    @Autowired
    List<IParameterResolver<SessionDTO>> resolvers;

    public SessionDTO process(SessionDTO sessionDTO){
        for (IParameterResolver<SessionDTO> resolver: resolvers) {
            resolver.resolve(sessionDTO);
        }
        return sessionDTO;
    }

}
