package com.xian.requireproject.service.templateManager.impl;

import com.xian.requireproject.repository.templateManager.entity.TemplateManagerEntity;
import com.xian.requireproject.repository.templateManager.mapper.TemplateManagerMapper;
import com.xian.requireproject.service.templateManager.TemplateManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class TemplateManagerServiceImpl implements TemplateManagerService {
    @Resource
    TemplateManagerMapper templateManagerMapper;
    @Override
    public List<Map<String, Object>> getTemplateManagerList(Map<String, Object> param) {
        return templateManagerMapper.getTemplateManagerList(param);
    }

    @Override
    public TemplateManagerEntity getTemplateManagerInfo(String uuid) {
        return templateManagerMapper.getTemplateManagerInfo(uuid);

    }

    @Override
    public void delTemplateManager(String uuid) {
        templateManagerMapper.delTemplateManager(uuid);

    }

    @Override
    public void addTemplateManager(TemplateManagerEntity entity) {
        templateManagerMapper.addTemplateManager(entity);
    }


}
