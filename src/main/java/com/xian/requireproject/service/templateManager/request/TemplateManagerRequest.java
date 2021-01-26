package com.xian.requireproject.service.templateManager.request;

import lombok.Data;

@Data
public class TemplateManagerRequest {
    private String uuid;
    private String number;
    private String title;
    private String status;
    private String person;
    private String priority;
    private String requireType;
    private String functionalDescription;
    private String createTime;
    private String remark;
    private String moduleName;
    private String projectType;
    private String creator;
    private String subjectTerm;
    private String templateState;
}
