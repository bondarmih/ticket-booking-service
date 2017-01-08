package com.bondarmih.ticketbooking.configuration;

import com.bondarmih.ticketbooking.service.dto.SessionDTO;
import com.bondarmih.ticketbooking.service.util.IParameterResolver;
import com.bondarmih.ticketbooking.service.util.session.PriceByDayOfWeekResolver;
import com.bondarmih.ticketbooking.service.util.session.PriceByTimeOfDayResolver;
import com.bondarmih.ticketbooking.service.util.session.PriceVipResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bondarm on 21.12.16.
 */

@Configuration
@ComponentScan(basePackages = "com.bondarmih.ticketbooking")
public class ApplicationConfiguration {

    @Bean
    List<IParameterResolver<SessionDTO>> sessionResolvers() {
        List<IParameterResolver<SessionDTO>> list = new ArrayList<>();
        list.add(new PriceVipResolver(200));//TODO carry all magic numbers out to properties
        list.add(new PriceByDayOfWeekResolver(1.3));
        list.add(new PriceByTimeOfDayResolver(1.2, 18));
        return list;
    }

}
