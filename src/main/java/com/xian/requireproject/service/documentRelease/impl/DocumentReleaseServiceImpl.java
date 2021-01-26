package com.xian.requireproject.service.documentRelease.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xian.requireproject.repository.documentrelease.entity.DocumentReleaseEntity;
import com.xian.requireproject.repository.documentrelease.mapper.DocumentReleaseMapper;
import com.xian.requireproject.service.documentRelease.DocumentReleaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class DocumentReleaseServiceImpl implements DocumentReleaseService {
    @Resource
    private DocumentReleaseMapper documentReleaseMapper;
    @Override
    //获取文档发布列表
    public Object getDocumentReleaseList(String uuid, int p, int c) {
        Page<DocumentReleaseEntity> objects = PageHelper.startPage(p,c);
        List<DocumentReleaseEntity> documentReleaseEntityList =documentReleaseMapper.getDocumentReleaseList(uuid);
        PageInfo<DocumentReleaseEntity> objectPageInfo =new PageInfo<>(documentReleaseEntityList);
        return objectPageInfo;
    }
   //根据编号获取信息
    @Override
    public DocumentReleaseEntity getDocumentReleaseInfo(String uuid) {
        return documentReleaseMapper.getDocumentReleaseInfo(uuid);
    }
}
