package com.xian.requireproject.service.storeManagement.request;

import lombok.Data;

@Data
public class StoreManagementRequest {
    private String warehouse_id;
    private String warehouse_files_id;//仓库文件id
    private String system_number;//系统编号
    private String project_name;//项目名称
    private String duty_officer;//责任人
    private String subject_term;//主题词
    private String priority;//优先级
    private String require_type;//需求类型
    private String create_time;
    private String remark;//备注

}
