package com.xian.requireproject.repository.requireapplicant.mapper;

import com.xian.requireproject.repository.requireapplicant.entity.CommentEntity;
//import com.xian.requireproject.repository.requireapplicant.entity.MilitaryZone;
import com.xian.requireproject.repository.requireapplicant.entity.MilitaryZone;
import com.xian.requireproject.repository.requireapplicant.entity.RequireEntity;
import com.xian.requireproject.repository.requireapplicant.provider.RequireProvider;
import com.xian.requireproject.repository.sysuser.entity.SysUserEntity;
import com.xian.requireproject.service.requireapplicant.request.RequireRequest;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface RequireMapper {
    @Insert("INSERT INTO require_applicant ( `uuid`, `number`, `project_name`, `status`, `subject_term`, `person`, `priority`, `require_type`, `fun_desc`, `create_time`, `remark`  , `statuss`)\n" +
            "VALUES\n" +
            "\t(#{uuid},#{number},#{projectName},0,#{subjectTerm},#{person},#{priority},#{requireType},#{funDesc},#{createTime},#{remark}, #{statuss});")
    void addRequire(RequireRequest requireRequest);

    @Update("UPDATE require_applicant SET  `number`= #{number},`project_name` = #{projectName}," +
            "`person` = #{person},`subject_term`= #{subjectTerm},`priority` = #{priority},`require_type` = #{requireType}," +
            "`fun_desc` = #{funDesc}," +
            "`remark`= #{remark} WHERE uuid = #{uuid}")

    void updRequire(RequireEntity requireEntity);

    @Delete("delete from require_applicant where uuid = #{uuid}")
    void delRequire(@Param("uuid") String uuid);

    @Select("select * from require_applicant r where r.uuid = #{uuid}")
    RequireRequest getRequireInfo(@Param("uuid") String uuid);

    @SelectProvider(method = "getRequireList", type = RequireProvider.class)
    List<RequireRequest> getRequireList(RequireRequest requireRequest);

    @SelectProvider(method = "getApproveList", type = RequireProvider.class)
    List<RequireRequest> getApproveList(RequireRequest requireRequest);

    @SelectProvider(method = "getAssistList", type = RequireProvider.class)
    List<RequireRequest> getAssistList(RequireRequest requireRequest);

    @SelectProvider(method = "getDocumentList", type = RequireProvider.class)
    List<RequireEntity> getDocumentList(RequireRequest requireRequest);

    @UpdateProvider(method = "submitDemand" , type = RequireProvider.class )
    void submitDemand(RequireRequest requireRequest);

    @UpdateProvider(method = "demandExamine" , type = RequireProvider.class )
    void demandExamine(RequireRequest requireRequest);

    @UpdateProvider(method = "demandExamines" , type = RequireProvider.class )
    void demandExamines(RequireRequest requireRequest);

    @InsertProvider(method = "addComment" , type = RequireProvider.class)
    void addComment(CommentEntity commentEntity);

    @SelectProvider(method = "queryComment" , type = RequireProvider.class)
    List<CommentEntity> queryComment(String rid);

    @Select("select id,name from military_zone")
    List<MilitaryZone> getZone();


    @Select("select uuid,nickName from sys_user WHERE area_id = #{userId}")
    List<SysUserEntity> getZoneUser(String userId);




}


