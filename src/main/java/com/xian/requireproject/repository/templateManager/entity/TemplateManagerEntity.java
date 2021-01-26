package com.xian.requireproject.repository.templateManager.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class TemplateManagerEntity implements Serializable {

    private Integer tempFileId;
    private String tempFileName;
    private String tempFilePath;
    private Integer tempStatus;
    private String tempType;
    private String areaId;
    private String tempRemark;
    private Integer createBy;
    private Date createTime;
    private Date updateTime;


}
