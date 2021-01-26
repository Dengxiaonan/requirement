package com.xian.requireproject.service.documentsearch;

import com.xian.requireproject.repository.documentsearch.entity.DocumentSearchEntity;

import java.util.List;
import java.util.Map;

public interface DocumentSearchService {

    List<Map<String, Object>> getDocumentSearchList(Map<String, Object> param);
    DocumentSearchEntity getDocumentInfo(String uuid);
}
