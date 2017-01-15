package com.bondarmih.ticketbooking.service;



import com.bondarmih.ticketbooking.data.dao.ISessionDAO;
import com.bondarmih.ticketbooking.service.dto.SessionDTO;
import com.bondarmih.ticketbooking.service.dto.builder.SessionDtoBuilder;
import com.bondarmih.ticketbooking.service.util.SessionParametersModifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by bondarm on 07.01.17.
 */

@Service
public class SessionService {

    @Autowired
    ISessionDAO sessionDao;

    @Autowired
    SessionParametersModifier sessionParametersModifier;



    public SessionDTO getSessionById(long id) {
        return this.processSession(
                SessionDtoBuilder.fromSession(sessionDao.getSessionById(id)));
    }


    public List<SessionDTO> getSessionsByMovieId(long movieId) {
        return sessionDao.getSessionsByMovieId(movieId)
                .stream()
                .map(SessionDtoBuilder::fromSession)
                .map(this::processSession)
                .collect(Collectors.toList());
    }

    private SessionDTO processSession(SessionDTO session) {
        return sessionParametersModifier.process(session);
    }

}
