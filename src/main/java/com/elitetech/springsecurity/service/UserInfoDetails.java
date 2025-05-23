package com.elitetech.springsecurity.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.elitetech.springsecurity.entity.UserInfo;
import java.util.Collection;
import java.util.Collections;

public class UserInfoDetails implements UserDetails {
    private static final long serialVersionUID = 1L;

    private String userName;
    private String password;

    public UserInfoDetails(UserInfo userInfo){
        this.userName = userInfo.getEmail();
        this.password = userInfo.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList(); // ✅ pas de rôle
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
