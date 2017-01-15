package com.bondarmih.ticketbooking.data.dao;

import com.bondarmih.ticketbooking.data.entity.Hall;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by bondarm on 08.01.17.
 */

@Repository
@Transactional
public class HallDAO extends AbstractHibernateDAO implements IHallDAO {
    @Override
    @SuppressWarnings("unchecked")
    public List<Hall> getAllHalls() {
        return this.getSession().createQuery("from Hall").list();
    }

    @Override
    public Hall getHallById(long id) {
        return (Hall)this.getSession().get(Hall.class, id);
    }

    @Override
    public void saveHall(Hall hall) {
        this.getSession().saveOrUpdate(hall);
    }

    @Override
    public void deleteHall(Hall hall) {
        this.getSession().delete(hall);
    }

    public void deleteHallById(Hall hall) {
        this.getSession().delete(hall);
    }

    @Override
    public void truncateHalls() {
        this.getSession().createQuery("delete from Hall ").executeUpdate();
    }
}
