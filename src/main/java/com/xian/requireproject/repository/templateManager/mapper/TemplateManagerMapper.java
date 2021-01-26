package com.xian.requireproject.repository.templateManager.mapper;

import com.xian.requireproject.repository.templateManager.entity.TemplateManagerEntity;
import com.xian.requireproject.repository.templateManager.provider.TemplateManagerProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface TemplateManagerMapper {
        @SelectProvider(method = "getTemplateManagerList", type = TemplateManagerProvider.class)
        List<Map<String, Object>> getTemplateManagerList(Map<String, Object> param);


        @Delete("delete from require_template_file where temp_file_id = #{uuid}")
        void delTemplateManager(@Param("uuid") String uuid);


        @Select("temp_file_id tempFileId,temp_file_name tempFileName,temp_file_path tempFilePath,temp_status tempStatus,temp_type tempType,create_by createBy,create_time createTime,update_time updateTime  WHERE uuid = #{uuid}")
        TemplateManagerEntity getTemplateManagerInfo(@Param("uuid") String uuid);

        @InsertProvider(method = "addTemplateManager", type = TemplateManagerProvider.class)
        void addTemplateManager(TemplateManagerEntity entity);
    }








