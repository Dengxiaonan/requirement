package com.xian.requireproject.repository.processManagement.mapper;

import com.xian.requireproject.repository.processManagement.entity.ProcessManageEntity;
import com.xian.requireproject.repository.requireapplicant.provider.RequireProvider;
import com.xian.requireproject.service.requireapplicant.request.RequireRequest;
import org.apache.ibatis.annotations.*;


import java.util.List;

@Mapper
public interface ProcessManageMapper {
    @SelectProvider(method = "getProcess", type = RequireProvider.class)
    List<RequireRequest> getProcess(RequireRequest requireRequest);

    @Select("SELECT\n" +
            "ra.uuid,\n" +
            "ra.number,\n" +
            "ra.project_name,\n" +
            "ra.status,\n" +
            "ra.subject_term,\n" +
            "ra.person,\n" +
            "ra.priority,\n" +
            "ra.require_type,\n" +
            "ra.fun_desc,\n" +
            "ra.create_time,\n" +
            "ra.remark,\n" +
            "ra.import_type,\n" +
            "su.user_name\n" +
            "FROM\n" +
            "\trequire_applicant ra \n" +
            "\tLEFT JOIN sys_user su ON su.uuid = ra.priority\n" +
            "\tWHERE\n" +
            "\t ra.uuid =  #{uuid}")
    RequireRequest getProcessInfo(@Param("uuid") String uuid);
    @Select("SELECT\n" +
            "ra.status\n" +
            "FROM\n" +
            "\trequire_applicant ra \n" +
            "\tWHERE\n" +
            "\tra.uuid =  #{uuid} \n")
    RequireRequest getQueryProcess(@Param("uuid") String uuid);
    @Delete("delete from require_applicant where uuid = #{uuid}")
    void delProcess(@Param("uuid") String uuid);
}
