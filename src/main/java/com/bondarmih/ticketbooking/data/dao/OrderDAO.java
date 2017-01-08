package com.bondarmih.ticketbooking.data.dao;

import com.bondarmih.ticketbooking.data.entity.Order;
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
        List<Order> orderList = this.getSession().createQuery("from Order o where o.user.id = ?")
                .setParameter(0, userId).list();
        return orderList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Order> getOrdersBySessionId(long sessionId) {
        List<Order> orderList = this.getSession().createQuery("from Order o where o.session.id = ?")
                .setParameter(0, sessionId).list();
        return orderList;
    }

    @Override
    public int getBookedRegSeatsCount(long sessionId) {
        return this.getSession().createQuery("select sum(Order.regSeats) from Order where Order.session.id = ?")
        .setParameter(0, sessionId).getFirstResult();
    }

    @Override
    public int getBookedVipSeatsCount(long sessionId) {
        return this.getSession().createQuery("select sum(Order.vipSeats) from Order where Order.session.id = ?")
                .setParameter(0, sessionId).getFirstResult();
    }

    @Override
    public void addOrder(Order order) {
        this.getSession().persist(order);
    }

    @Override
    public void truncateOrders() {
        this.getSession().createQuery("delete from Order");
    }
}