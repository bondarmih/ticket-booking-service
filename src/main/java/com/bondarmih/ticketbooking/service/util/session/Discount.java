package com.bondarmih.ticketbooking.service.util.session;

/**
 * Created by bondarm on 13.01.17.
 */
public interface Discount {

    String getDescription();
    boolean isForAuth();
    boolean isFixed();
}
