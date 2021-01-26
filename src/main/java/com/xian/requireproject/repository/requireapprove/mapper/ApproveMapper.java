package com.xian.requireproject.repository.requireapprove.mapper;

import com.xian.requireproject.repository.requireapprove.entity.ApproveEntity;
import com.xian.requireproject.repository.requireapprove.privider.ApproveProvider;
import com.xian.requireproject.service.requireapplicant.request.RequireRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;


@Mapper
public interface ApproveMapper {
        @SelectProvider(method = "approveCommit", type = ApproveProvider.class)
        void approveCommit(Map<String, Object> param);

        @Update("UPDATE require_approve SET `status` = #{status} WHERE uuid = #{uuid}")
        void updApprove(ApproveEntity approveEntity);

        @Delete("delete from require_approve where uuid = #{uuid}")
        void delApprove(@Param("uuid") String uuid);

        //详情，查看单条信息
        @Select("SELECT a.uuid UUID, a.number number, a.project_name projectName, a.status STATUS, b.nick_name person, a.subject_term subjectTerm, a.priority priority, a.require_type requireType, a.fun_desc funDesc, a.create_time createTime, a.remark remark FROM require_applicant a LEFT OUTER JOIN sys_user b ON a.person = b.uuid WHERE a.uuid = #{uuid}")
        RequireRequest getByIdApproveInfo(@Param("uuid") String uuid);

//        @Select("select * from require_applicant a where a.status = #{status} and a.area_id = #{areaId}")
//        List<RequireRequest> getApproveList(Map<String, Object> param);

        @SelectProvider(method = "getApproveList", type = ApproveProvider.class)
        List<RequireRequest> getApproveList(Map<String, Object> param);
    }