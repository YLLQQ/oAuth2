package com.jn.service.authroization.server.service;

import com.jn.service.authroization.server.mapper.ClientInfoMapper;
import com.jn.service.authroization.server.model.domain.ClientInfoDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;
import self.yang.mybatis.mapper.BaseMapper;
import self.yang.mybatis.service.BaseMybatisService;

@Slf4j
@Service
public class ClientInfoService extends BaseMybatisService<ClientInfoDO> implements ClientDetailsService {

    @Autowired
    private ClientInfoMapper clientInfoMapper;

    @Override
    protected BaseMapper getMapper() {
        return clientInfoMapper;
    }

    @Override
    protected String getTableName() {
        return "client_info";
    }

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        ClientInfoDO clientInfoByClientId = clientInfoMapper.getClientInfoByClientId(clientId);

        if (log.isInfoEnabled()) {
            log.info("get client info by {} is {}", clientId, clientInfoByClientId);
        }

        return clientInfoByClientId;
    }


}
