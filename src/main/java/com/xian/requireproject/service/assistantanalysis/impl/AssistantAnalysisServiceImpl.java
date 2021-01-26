package com.xian.requireproject.service.assistantanalysis.impl;

import com.xian.requireproject.repository.assistantanalysis.entity.AssistantAnalysisEntity;
import com.xian.requireproject.repository.assistantanalysis.mapper.AssistantAnalysisMapper;
import com.xian.requireproject.service.assistantanalysis.AssistantAnalysisService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class AssistantAnalysisServiceImpl implements AssistantAnalysisService {
    @Resource
    private AssistantAnalysisMapper assistantAnalysisMapper;
    @Override
    public List<AssistantAnalysisEntity> getAssAll() {
        return assistantAnalysisMapper.getAssAll();
    }

    @Override
    public AssistantAnalysisEntity getAssistantInfo(String uuid) {
        return assistantAnalysisMapper.getAssistantInfo(uuid);
    }
}
