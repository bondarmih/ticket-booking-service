package com.bondarmih.ticketbooking.service;

import com.bondarmih.ticketbooking.data.dao.IHallDAO;
import com.bondarmih.ticketbooking.data.entity.Hall;
import com.bondarmih.ticketbooking.data.entity.builder.HallBuilder;
import com.bondarmih.ticketbooking.service.dto.HallDTO;
import com.bondarmih.ticketbooking.service.dto.builder.HallDtoBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by bondarm on 15.01.17.
 */
@Service
public class HallService {

    @Autowired
    IHallDAO hallDAO;

    public List<HallDTO> getAllHalls() {
        return hallDAO.getAllHalls()
                .stream()
                .map(HallDtoBuilder::fromHall)
                .collect(Collectors.toList());
    }

    public HallDTO getHallById(long id) {
        return HallDtoBuilder.fromHall(hallDAO.getHallById(id));
    }

    public void saveOrUpdate(HallDTO hall) {
        this.hallDAO.saveHall(new HallBuilder().fromHallDto(hall));
    }

    public void deleteHall(long id) {
        Hall hall = this.hallDAO.getHallById(id);
        if (hall != null) {
            this.hallDAO.deleteHall(hall);
        }
    }
}
