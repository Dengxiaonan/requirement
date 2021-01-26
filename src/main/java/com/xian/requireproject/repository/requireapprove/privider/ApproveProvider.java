package com.xian.requireproject.repository.requireapprove.privider;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * @Date 2021/1/18 11:44
 */
public class ApproveProvider extends SQL {


    public String approveCommit(Map<String, Object> param) {
        String s = new SQL(){{
            UPDATE("require_applicant");
            SET("status = #{status}");
            SET("examine = #{examine}");
            SET("update_time = #{updateTime}");
            if (StringUtils.isNotBlank((String)param.get("requireBackCause"))) {
                SET("require_back_cause = #{requireBackCause}");
            }
            if (StringUtils.isNotBlank((String)param.get("requireRefCause"))) {
                SET("require_ref_cause = #{requireRefCause}");
            }
            WHERE("uuid = #{uuid}");
            WHERE("status = 1");
        }}.toString();
        System.out.println(s);
        return s;
    }

    public String getApproveList(Map<String, Object> param) {
        String s = new SQL() {{
            SELECT("a.uuid UUID, a.number number, a.project_name projectName, a.status STATUS, b.nick_name person, a.subject_term subjectTerm, a.priority priority, a.require_type requireType, a.fun_desc funDesc, a.create_time createTime, a.remark remark");
            FROM("require_applicant a");
            LEFT_OUTER_JOIN("sys_user b on a.person = b.uuid");
            WHERE("a.status = 1");//状态0未提交1待审批2已审批(已发布)3已退回4拒绝
            WHERE("a.area_id = #{areaId}");
            if (StringUtils.isNotEmpty((String)param.get("number"))) {
                WHERE("a.number = #{number}");
            }
            if (StringUtils.isNotEmpty((String)param.get("subjectTerm"))) {
                WHERE("a.subject_term = #{subjectTerm}");
            }
            if (StringUtils.isNotEmpty((String)param.get("statuss"))) {
                WHERE("a.statuss = #{statuss}");
            }
        }}.toString();
        System.out.println(s);
        return s;
    }
}
