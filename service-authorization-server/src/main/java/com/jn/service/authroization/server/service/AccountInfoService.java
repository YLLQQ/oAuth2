package com.jn.service.authroization.server.service;

import com.jn.service.authroization.server.mapper.AccountInfoMapper;
import com.jn.service.authroization.server.model.domain.AccountInfoDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import self.yang.mybatis.mapper.BaseMapper;
import self.yang.mybatis.service.BaseMybatisService;

@Slf4j
@Service
public class AccountInfoService extends BaseMybatisService<AccountInfoDO> implements UserDetailsService {

    @Autowired
    private AccountInfoMapper accountInfoMapper;

    @Override
    protected BaseMapper<AccountInfoDO> getMapper() {
        return accountInfoMapper;
    }

    @Override
    protected String getTableName() {
        return "account_info";
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        AccountInfoDO accountInfoByUsername = accountInfoMapper.getAccountInfoByUsername(s);

        if (log.isInfoEnabled()) {
            log.info("get account info by {} is {}", s, accountInfoByUsername);
        }

        return accountInfoByUsername;
    }


}
