package com.bondarmih.ticketbooking.service.util;

/**
 * Created by bondarm on 08.01.17.
 */
public interface IParameterModifier<T> {
    T modify(T input);
    boolean check(T input);

}
