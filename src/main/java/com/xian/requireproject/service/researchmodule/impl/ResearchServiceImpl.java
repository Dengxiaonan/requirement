package com.xian.requireproject.service.researchmodule.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xian.requireproject.common.MapperUtils;
import com.xian.requireproject.common.UUIDUtils;
import com.xian.requireproject.repository.researchmodule.entity.ResearchEntity;
import com.xian.requireproject.repository.researchmodule.mapper.ResearchMapper;
import com.xian.requireproject.service.researchmodule.ResearchService;
import com.xian.requireproject.service.researchmodule.request.ResearchRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ResearchServiceImpl implements ResearchService {

    @Resource
    ResearchMapper researchMapper;

    @Override
    public void addResearch(ResearchRequest researchRequest) {
        ResearchEntity researchEntity = MapperUtils.mapperBean(researchRequest, ResearchEntity.class);
        researchEntity.setUuid(UUIDUtils.getUUID());
        researchMapper.addResearch(researchEntity);

    }

    @Override
    public Object getResearchList(String uuid, int p, int c) {
        Page<ResearchEntity> objects = PageHelper.startPage(p, c);
        List<ResearchEntity> researchList = researchMapper.getResearchList(uuid);
        PageInfo<ResearchEntity> objectPageInfo = new PageInfo<>(researchList);

        return objectPageInfo;
    }
  //浏览单条信息
    @Override
    public ResearchEntity getResearchInfo(String uuid) {

        return researchMapper.getResearchInfo(uuid);
    }
//根据id删除信息
    @Override
    public void delResearch(String uuid){
        researchMapper.delResearch(uuid);
    }

}

