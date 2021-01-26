package com.xian.requireproject.repository.researchmodule.mapper;

import com.xian.requireproject.repository.researchmodule.entity.ResearchEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ResearchMapper {
    @Insert("INSERT INTO require_research_module(`number`,`project_name`,`responsible`,`status`,`priority`,`require_type`," +
                "`functional_description`,`remark`,`module_name`,`module_version`,`issuer`,`create_time`,`subject_term`,`operation`,`reserve`,)" +
            " VALUES (#{number},#{projectName},#{responsible},#{status},#{priority},#{requireType},#{functionalDescription},#{remark},#{moduleName},#{moduleVersion},#{issuer}," +
                "#{createTime},#{subjectTerm},#{operation},#{reserve})")

    void addResearch(ResearchEntity researchEntity);

    @Select("SELECT * FROM require_research_module r WHERE r.uuid = #{uuid}")
    List<ResearchEntity> getResearchList(@Param("uuid") String uuid);

    //浏览，查看单条信息
    @Select("SELECT `uuid`,`number`,`project_name`,`status`,`person`,`priority`," +
            " FROM require_research_module  WHERE uuid = #{uuid}")

    ResearchEntity getResearchInfo(@Param("uuid") String uuid);

    @Delete("delete from require_research_module where uuid = #{uuid}")
    void delResearch(@Param("uuid") String uuid);
}
