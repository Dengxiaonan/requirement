package com.xian.requireproject.service.documentRelease;

import com.xian.requireproject.repository.documentrelease.entity.DocumentReleaseEntity;

public interface DocumentReleaseService {

    //发布

    //查询列表
    Object getDocumentReleaseList(String uuid,int p, int c);
    //根据用户编号获取信息
    DocumentReleaseEntity getDocumentReleaseInfo(String uuid);
}
