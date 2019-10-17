package com.jn.service.authroization.server.model.domain;

import com.google.common.collect.Lists;
import com.jn.service.authroization.server.tool.StringTool;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import self.yang.model.domain.BaseDO;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

@Data
public class ClientInfoDO implements ClientDetails, BaseDO {

    private Integer id;

    private String clientId;

    private String clientSecret;

    private boolean secretRequired;

    private boolean scoped;

    private boolean autoApprove;

    private Integer accessTokenValiditySeconds;

    private Integer refreshTokenValiditySeconds;

    private String resourceIdsUnit;

    private String scopeUnit;

    private String authorizedGrantTypesUnit;

    private String registeredRedirectUriUnit;

    @Override
    public Set<String> getResourceIds() {
        return StringTool.str2Set(getResourceIdsUnit());
    }

    @Override
    public Set<String> getScope() {
        return StringTool.str2Set(getScopeUnit());
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return StringTool.str2Set(getAuthorizedGrantTypesUnit());
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return StringTool.str2Set(getRegisteredRedirectUriUnit());
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority admin = new SimpleGrantedAuthority("admin");

        return Lists.newArrayList(admin);
    }

    @Override
    public boolean isAutoApprove(String scope) {
        return isScoped();
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return null;
    }

}
