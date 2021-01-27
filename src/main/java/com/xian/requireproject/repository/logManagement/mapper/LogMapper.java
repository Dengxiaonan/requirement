package com.xian.requireproject.repository.logManagement.mapper;

import com.xian.requireproject.repository.logManagement.entity.LogEntity;
import com.xian.requireproject.repository.logManagement.provider.LogProvider;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LogMapper {
    @SelectProvider(method = "getLogList", type = LogProvider.class)
    List<LogEntity> getLogList(LogEntity logEntity);

    //详情
    /*@Select("SELECT `uuid`,`log_number`,`system_module`,`operation_type`,`request_method`,`operator`," +
            " FROM log_management  WHERE uuid = #{uuid}")

    LogEntity getLogInfo(@Param("uuid") String uuid);*/

    @Delete("delete from log_management WHERE log_id = #{logid}")
    void delLog(@Param("uuid") String logid);

    @Delete("delete from log_management")
    void delLogInfo();
}
