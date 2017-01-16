package com.bondarmih.ticketbooking.data.dao;

import com.bondarmih.ticketbooking.data.entity.UserRole;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by bondarm on 03.01.17.
 */

@Repository
@Transactional
public class UserRoleDAO extends AbstractHibernateDAO implements IUserRoleDAO {

    @Override
    @SuppressWarnings("unchecked")
    public List<UserRole> getAllUserRoles() {
        Session session = getSession();
        List<UserRole> userRoleList = session.createQuery("from UserRole").list();
        return userRoleList;
    }

    @Override
    public UserRole getUserRoleById(long id) {
        Session session = getSession();
        UserRole userRole = (UserRole) session.load(UserRole.class, id);
        return userRole;
    }

    @Override
    @SuppressWarnings("unchecked")
    public UserRole getUserRoleByName(String name) {
        Session session = getSession();
        List<UserRole> roleList = (List<UserRole>) session.createQuery("from UserRole r where r.name = :name")
                .setString("name", name).list();
        if (roleList.size() == 0) {
            return null;
        }
        return roleList.get(0);
    }

    @Override
    public void addUserRole(UserRole userRole) {
        Session session = getSession();
        session.save(userRole);
    }

    public void truncateUserRoles() {
        Session session = getSession();
        session.createQuery("delete from UserRole ").executeUpdate();
    }
}
