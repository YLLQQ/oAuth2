package com.jn.service.authroization.server.model.domain;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import self.yang.model.domain.BaseDO;

import java.util.Collection;

@Data
public class AccountInfoDO implements UserDetails, BaseDO {
    private Integer id;

    private String username;

    private String password;

    private boolean enabled;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
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
}
