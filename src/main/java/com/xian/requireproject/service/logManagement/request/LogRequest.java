package com.xian.requireproject.service.logManagement.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LogRequest {
    private Integer logId;
    private String uuid;
    private LocalDateTime operationTime;
    private String loginName;
    private String operation;
    private String ip;
    private String describe;
    private String details;


}
