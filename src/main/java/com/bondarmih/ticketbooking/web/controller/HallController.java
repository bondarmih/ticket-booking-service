package com.bondarmih.ticketbooking.web.controller;

import com.bondarmih.ticketbooking.service.HallService;
import com.bondarmih.ticketbooking.service.dto.HallDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by bondarm on 15.01.17.
 */
@Controller
@RequestMapping("/api/halls")
public class HallController {

    @Autowired
    HallService hallService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody
    List<HallDTO> getAllHalls() {
        return this.hallService.getAllHalls();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    HallDTO getHallById(@PathVariable long id) {
        return this.hallService.getHallById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void saveHall(@RequestBody HallDTO hall) {
        this.hallService.saveOrUpdate(hall);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteHallById(@PathVariable long id) {
        this.hallService.deleteHall(id);
    }
}
