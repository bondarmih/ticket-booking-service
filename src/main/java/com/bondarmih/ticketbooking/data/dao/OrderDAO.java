package com.bondarmih.ticketbooking.data.dao;

import com.bondarmih.ticketbooking.data.entity.Order;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by bondarm on 08.01.17.
 */

@Repository
@Transactional
public class OrderDAO extends AbstractHibernateDAO implements IOrderDAO {
    @Override
    @SuppressWarnings("unchecked")
    public List<Order> getAllOrders() {
        List<Order> orderList = this.getSession().createQuery("from Order").list();
        return orderList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Order> getOrdersByUserId(long userId) {
        Query query = this.getSession().createQuery("from Order where user.id = :userId");
        query.setLong("userId", userId);
        List<Order> orderList = query.list();
        return orderList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Order> getOrdersBySessionId(long sessionId) {
        List<Order> orderList = this.getSession().createQuery("from Order o where o.movieSession.id = ?")
                .setParameter(0, sessionId).list();
        return orderList;
    }

    @Override
    public int getBookedRegSeatsCount(long sessionId) {
        return this.getSession().createQuery("select sum(Order.regSeats) from Order where Order.movieSession.id = :sessionId")
                .getFirstResult();
    }

    @Override
    public int getBookedVipSeatsCount(long sessionId) {
        return this.getSession().createQuery("select sum(Order.vipSeats) from Order where Order.movieSession.id = :sessionId")
                .getFirstResult();
    }

    @Override
    public long addOrder(Order order) {
        this.getSession().save(order);
        return order.getId();
    }

    @Override
    public void truncateOrders() {
        this.getSession().createQuery("delete from Order");
    }

    @Override
    public long getTicketsCountByUser(long userId) {
        Query query = this.getSession().createQuery("select sum(regSeats) + sum(vipSeats) from Order where user.id = :userId");
        query.setLong("userId", userId);
        Long result = (Long)query.list().get(0);
        return (result == null ? 0 : result);
    }
}
