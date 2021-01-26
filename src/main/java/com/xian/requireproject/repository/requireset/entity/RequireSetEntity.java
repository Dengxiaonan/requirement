package com.xian.requireproject.repository.requireset.entity;

import lombok.Data;

import java.util.Date;

@Data
public class RequireSetEntity {
    private Integer reqSetId;    //主键id
    private String reqSysNum;   //系统编号
    private String projectName; //项目名称
    private String requireType; //需求类型
    private String subjectTerm;    //主题词
    private String reqTitle;    //标题
    private String reqStatus;   //状态0未发布1已发布
    private String person;      //负责人
    private Date createTime;//创建时间
    private String areaId;//区域id
    private String filePath;//文件路径
    private String fileName;//文件名称


}
