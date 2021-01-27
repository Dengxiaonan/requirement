package com.xian.requireproject.repository.logManagement.provider;

import com.xian.requireproject.repository.logManagement.entity.LogEntity;
import io.micrometer.core.instrument.util.StringUtils;
import org.apache.ibatis.jdbc.SQL;

public class LogProvider extends SQL {
    public String getLogList(LogEntity logEntity){
        String s = new SQL(){{
            SELECT("SELECT `log_id`, `uuid`, `operation_time`, `\n" +
                    "login_name`, `operation`, `ip`, `details`");
            FROM("log_management");
            if (StringUtils.isNotEmpty(logEntity.getLoginName())) {
                WHERE("operation_time like concat('%',#{loginname},'%')");
            }
            if (StringUtils.isNotEmpty(logEntity.getDetails())) {
                WHERE("details like concat('%',#{details},'%')");
            }
            if (StringUtils.isNotEmpty(logEntity.getDetails())) {
                WHERE("details like concat('%',#{details},'%')");
            }
            if (StringUtils.isNotEmpty(logEntity.getStartime())) {
                WHERE("date  >= #{startime}");
            }
            if (StringUtils.isNotEmpty(logEntity.getEndtime())) {
                WHERE("date <= #{endtime}");
            }
        }}.toString();
        return s;
    }
}
