package com.xian.requireproject.service.documentsearch.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xian.requireproject.repository.documentsearch.entity.DocumentSearchEntity;
import com.xian.requireproject.repository.documentsearch.mapper.DocumentSearchMapper;
import com.xian.requireproject.service.documentsearch.DocumentSearchService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class DocumentSearchServiceImpl implements DocumentSearchService {

    @Resource
    DocumentSearchMapper documentsearchMapper;


    @Override
    public List<Map<String, Object>> getDocumentSearchList(Map<String, Object> param) {
        return documentsearchMapper.getDocumentSearchList(param);
    }

    @Override
    public DocumentSearchEntity getDocumentInfo(String uuid) {
        return documentsearchMapper.getDocumentInfo(uuid);
    }
}
