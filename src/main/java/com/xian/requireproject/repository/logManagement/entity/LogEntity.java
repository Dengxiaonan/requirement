package com.xian.requireproject.repository.logManagement.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LogEntity {
    private Integer logId;
    private String uuid;
    private LocalDateTime operationTime;
    private String loginName;
    private String operation;
    private String ip;
    private String details;


}
