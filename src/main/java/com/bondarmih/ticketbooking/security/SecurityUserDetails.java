package com.bondarmih.ticketbooking.security;

import com.bondarmih.ticketbooking.entity.UserRole;
import com.bondarmih.ticketbooking.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by bondarm on 14.08.16.
 */
public class SecurityUserDetails extends User implements UserDetails {

    public SecurityUserDetails(User user) {
        if(user != null)
        {
            this.setId(user.getId());
            this.setName(user.getName());
            this.setPassword(user.getPassword());
            this.setRoles(user.getRoles());
        }
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        Set<UserRole> userRoles = this.getRoles();
        if(userRoles != null)
        {
            for (UserRole userRole : userRoles) {
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole.getName());
                authorities.add(authority);
            }
        }
        return authorities;
    }

    public String getUsername() {
        return super.getName();
    }

    public String getPassword() {
        return super.getPassword();
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }
}
