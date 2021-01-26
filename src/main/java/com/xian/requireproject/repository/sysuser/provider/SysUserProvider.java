package com.xian.requireproject.repository.sysuser.provider;

import com.xian.requireproject.repository.sysuser.entity.SysUserEntity;
import com.xian.requireproject.service.sysuser.request.ParamVO;
import io.micrometer.core.instrument.util.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * @author ldy
 * @date
 * @email
 *  //            LEFT_OUTER_JOIN("ehr_employee ee on ee.id = ees.id");
 */
public class SysUserProvider extends SQL {
    public String getUserList(Map<String, Object> param) {
        return new SQL() {{

            SELECT("uuid uuid,nick_name nickName,user_name userName,status status,create_time createTime, area_id areaId, role_id roleId");
            FROM("sys_user");
            WHERE("del_flag = 0 ");
            WHERE("area_id = #{areaId} ");
            if (StringUtils.isNotEmpty((String)param.get("nickName"))) {
                WHERE("nick_name like concat('%',#{nickName},'%')");
            }
            if (StringUtils.isNotEmpty((String)param.get("status"))) {
                WHERE("status = #{status}");
            }
            ORDER_BY("create_time desc ");
        }}.toString();
    }

    public String addSysUser(SysUserEntity sysUserEntity) {

        String sql = new SQL() {{
            INSERT_INTO("sys_user");
            INTO_COLUMNS("nick_name", "role_id", "status", "remark", "user_name", "password", "del_flag", "create_by", "area_id", "create_time", "update_time");
            INTO_VALUES("#{nickName}", "#{roleId}", "#{status}", "#{remark}", "#{userName}", "#{password}", "#{delFlag}", "#{createBy}", "#{areaId}", "#{createTime}", "#{updateTime}");
        }}.toString();
        return sql;
    }


    public String updateUserInfo(SysUserEntity sysUserEntity) {
        return new SQL() {
            {
                UPDATE("sys_user");
                if (StringUtils.isNotBlank(sysUserEntity.getNickName())) {
                    SET("nick_name = #{nickName}");
                }
                if (StringUtils.isNotBlank(sysUserEntity.getRoleId())) {
                    SET("role_id = #{roleId}");
                }
                if (null != sysUserEntity.getStatus()) {
                    SET("status = #{status}");
                }
                if (StringUtils.isNotBlank(sysUserEntity.getAreaId())) {
                    SET("area_id = #{areaId}");
                }
                if (StringUtils.isNotBlank(sysUserEntity.getRemark())) {
                    SET("remark = #{remark}");
                }
                if (StringUtils.isNotBlank(sysUserEntity.getPassword())) {
                    SET("password = #{password}");
                }
                if (null != sysUserEntity.getUpdateTime()) {
                    SET("update_time = #{updateTime}");
                }
                WHERE("uuid = #{uuid}");
            }
        }.toString();
    }


}
