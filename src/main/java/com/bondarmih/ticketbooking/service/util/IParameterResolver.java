package com.bondarmih.ticketbooking.service.util;

/**
 * Created by bondarm on 08.01.17.
 */
public interface IParameterResolver<T> {
    T resolve(T input);
    boolean check(T input);
}
