package com.bondarmih.ticketbooking.service.util.session;

import com.bondarmih.ticketbooking.service.dto.SessionDTO;
import com.bondarmih.ticketbooking.service.util.IParameterResolver;

/**
 * Created by bondarm on 08.01.17.
 */
public class PriceVipResolver implements IParameterResolver<SessionDTO> {

    private final int VIP_PRICE_OVERHEAD;

    public PriceVipResolver(int vipOvedhead) {
        this.VIP_PRICE_OVERHEAD = vipOvedhead;
    }

    @Override
    public SessionDTO resolve(SessionDTO input) {
        input.setPriceVip(input.getPriceVip() + this.VIP_PRICE_OVERHEAD);
        return input;
    }

    @Override
    public boolean check(SessionDTO input) {
        return true;
    }
}
