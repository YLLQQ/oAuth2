package com.jn.service.authroization.server.mapper;

import com.jn.service.authroization.server.model.domain.ClientInfoDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import self.yang.mybatis.mapper.BaseMapper;

@Mapper
public interface ClientInfoMapper extends BaseMapper<ClientInfoDO> {

    @Select("select * from client_info where client_id=#{clientId}")
    ClientInfoDO getClientInfoByClientId(@Param("clientId") String clientId);
}
