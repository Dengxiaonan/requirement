package com.xian.requireproject.repository.processManagement.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProcessManageEntity {
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
