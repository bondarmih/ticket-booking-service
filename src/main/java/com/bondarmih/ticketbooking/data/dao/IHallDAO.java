package com.bondarmih.ticketbooking.data.dao;

import com.bondarmih.ticketbooking.data.entity.Hall;

import java.util.List;

/**
 * Created by bondarm on 08.01.17.
 */
public interface IHallDAO {

    List<Hall> getAllHalls();
    void addHall(Hall hall);
    void truncateHalls();
}
