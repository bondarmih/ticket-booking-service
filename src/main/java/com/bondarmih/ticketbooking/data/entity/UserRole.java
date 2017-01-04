package com.bondarmih.ticketbooking.data.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by bondarm on 22.12.16.
 */

@Entity
@Table(name="userrole")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="roles")
    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String toString() {
        return getName();
    }
}
