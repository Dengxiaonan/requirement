package com.xian.requireproject.repository.templateManager.provider;

import com.xian.requireproject.repository.templateManager.entity.TemplateManagerEntity;
import io.micrometer.core.instrument.util.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class TemplateManagerProvider extends SQL {

    public String getTemplateManagerList(Map<String, Object> param) {
        return new SQL() {{

            SELECT("a.temp_file_id tempFileId,a.temp_file_name tempFileName,a.temp_file_path tempFilePath,a.temp_status tempStatus,a.temp_type tempType,b.nick_name nickName,DATE_FORMAT(a.create_time,'%Y-%m-%d %H:%i:%s') createTime,DATE_FORMAT(a.update_time,'%Y-%m-%d %H:%i:%s') updateTime, a.temp_remark tempRemark");
            FROM("require_template_file a");
            LEFT_OUTER_JOIN("sys_user b on a.create_by = b.uuid");
            WHERE("a.area_id = #{areaId} ");
            if (StringUtils.isNotEmpty((String)param.get("tempFileName"))) {
                WHERE("a.temp_file_name like concat('%',#{tempFileName},'%')");
            }
            if (StringUtils.isNotEmpty((String)param.get("tempType"))) {
                WHERE("a.temp_type = #{tempType}");
            }
            ORDER_BY("a.temp_file_id desc ");
        }}.toString();
    }

    public String addTemplateManager(TemplateManagerEntity entity){
        String sql = new SQL(){{
            INSERT_INTO("require_template_file");
            if (StringUtils.isNotBlank(entity.getTempFileName())) {
                VALUES("temp_file_name","#{tempFileName}");
            }
            if (StringUtils.isNotBlank(entity.getTempFilePath())) {
                VALUES("temp_file_path","#{tempFilePath}");
            }
            if (null != entity.getTempStatus()) {
                VALUES("temp_status","#{tempStatus}");
            }
            if (StringUtils.isNotBlank(entity.getTempType())) {
                VALUES("temp_type","#{tempType}");
            }
            if (StringUtils.isNotBlank(entity.getAreaId())) {
                VALUES("area_id","#{areaId}");
            }
            if (StringUtils.isNotBlank(entity.getTempRemark())) {
                VALUES("temp_remark","#{tempRemark}");
            }
            if (null != entity.getCreateBy()) {
                VALUES("create_by","#{createBy}");
            }
            if (null != entity.getCreateTime()) {
                VALUES("create_time","#{createTime}");
            }
            if (null != entity.getUpdateTime()) {
                VALUES("update_time","#{updateTime}");
            }

        }}.toString();
        return sql;
    }
}
