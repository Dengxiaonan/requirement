package com.xian.requireproject.repository.documentrelease.entity;

import lombok.Data;

@Data
public class DocumentReleaseEntity {
private String uuid;
private String number;//编号
private String title;//标题
private String subjectTerms;//主题词
private String status;//状态0为申请中1同意2拒绝3退回4已申请
private String person;//负责人
private String priority;//优先级
private String requireType;//需求类型
private String functionalDescription;//功能描述
private String createTime;//创建时间
private String remark;//备注


}
