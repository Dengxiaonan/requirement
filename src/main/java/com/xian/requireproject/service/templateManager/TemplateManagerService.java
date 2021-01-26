package com.xian.requireproject.service.templateManager;


import com.xian.requireproject.repository.templateManager.entity.TemplateManagerEntity;

import java.util.List;
import java.util.Map;

public interface TemplateManagerService {

    //查询列表
    List<Map<String, Object>> getTemplateManagerList(Map<String, Object> param);

    //详情
    TemplateManagerEntity getTemplateManagerInfo(String uuid);

    //删除
    void delTemplateManager(String uuid);

    void addTemplateManager(TemplateManagerEntity entity);

}
