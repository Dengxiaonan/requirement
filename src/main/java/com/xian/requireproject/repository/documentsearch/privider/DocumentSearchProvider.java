package com.xian.requireproject.repository.documentsearch.privider;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * @Date 2021/1/18 11:44
 */
public class DocumentSearchProvider extends SQL {


    public String getDocumentSearchList(Map<String, Object> param) {
        String s = new SQL() {{
            SELECT("b.uuid UUID, a.require_file_id AS requireFileId, b.number number, b.project_name projectName, a.file_name fileName, c.nick_name nickName,  b.remark remark");
            FROM("require_file a");
            LEFT_OUTER_JOIN("require_applicant b on a.require_id = b.uuid");
            LEFT_OUTER_JOIN("sys_user c on b.person = c.uuid");

            WHERE("a.file_status = 0");     //文件状态(0正常1删除)
            WHERE("b.area_id = #{areaId}"); //区域
            if (StringUtils.isNotEmpty((String)param.get("number"))) {
                WHERE("b.number LIKE CONCAT('%',#{number},'%')");
            }
            if (StringUtils.isNotEmpty((String)param.get("projectName"))) {
                WHERE("b.project_name LIKE CONCAT('%',#{projectName},'%')");
            }
            if (StringUtils.isNotEmpty((String)param.get("nickName"))) {
                WHERE("c.nick_name LIKE CONCAT('%',#{nickName},'%')");
            }
        }}.toString();
        System.out.println(s);
        return s;
    }

}
