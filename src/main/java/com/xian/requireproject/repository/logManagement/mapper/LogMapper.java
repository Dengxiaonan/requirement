package com.xian.requireproject.repository.logManagement.mapper;

import com.xian.requireproject.repository.logManagement.entity.LogEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LogMapper {
    @Select("SELECT * FROM log_management o WHERE o.uuid = #{uuid}")
    List<LogEntity> getLogList(@Param("uuid") String uuid);

    //详情
    @Select("SELECT `uuid`,`log_number`,`system_module`,`operation_type`,`request_method`,`operator`," +
            " FROM log_management  WHERE uuid = #{uuid}")

    LogEntity getLogInfo(@Param("uuid") String uuid);

    @Delete("delete from log_management WHERE uuid = #{uuid}")
    void delLog(@Param("uuid") String uuid);

    @Delete("delete from log_management")
    void delLogInfo();
}
