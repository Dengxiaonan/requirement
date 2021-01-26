package com.xian.requireproject.service.processManagement.request;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ProcessManageRequest {
    private String uuid;
    private String number;
    private String type;
    private String keywords;
    private String issuer;//发布人
    private String projectName;
    private String fileName;
    private String details;
    private String remark;
    private LocalDateTime createTime;




}
