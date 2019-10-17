package com.jn.service.authroization.server.mapper;

import com.jn.service.authroization.server.model.domain.AccountInfoDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import self.yang.mybatis.mapper.BaseMapper;

@Mapper
public interface AccountInfoMapper extends BaseMapper<AccountInfoDO> {

    @Select("select * from account_info where username=#{username}")
    AccountInfoDO getAccountInfoByUsername(@Param("username") String username);
}
