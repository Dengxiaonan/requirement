package com.xian.requireproject.service.assistantanalysis;

import com.xian.requireproject.repository.assistantanalysis.entity.AssistantAnalysisEntity;

import java.util.List;

public interface AssistantAnalysisService {
    List<AssistantAnalysisEntity> getAssAll();
    //浏览
    AssistantAnalysisEntity getAssistantInfo(String uuid);
}
