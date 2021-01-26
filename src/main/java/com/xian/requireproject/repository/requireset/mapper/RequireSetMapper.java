package com.xian.requireproject.repository.requireset.mapper;

import com.xian.requireproject.repository.requireset.entity.RequireSetEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;


@Mapper
public interface RequireSetMapper {

        //详情，查看单条信息
        @Select("select req_set_id   reqSetId, req_sys_num  reqSysNum, project_name projectName, require_type requireType, subject_term subjectTerm,req_title reqTitle, req_status reqStatus, person person, create_time createTime, area_id areaId from require_set where area_id = #{areaId}")
        List<RequireSetEntity> getRequireSetList(Map<String, Object> paramMap);
    }