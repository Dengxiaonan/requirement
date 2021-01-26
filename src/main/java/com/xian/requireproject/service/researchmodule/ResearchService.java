package com.xian.requireproject.service.researchmodule;

import com.xian.requireproject.repository.researchmodule.entity.ResearchEntity;
import com.xian.requireproject.service.researchmodule.request.ResearchRequest;

public interface ResearchService {

    void addResearch(ResearchRequest researchRequest);

    Object getResearchList(String uuid,int p, int c);

    //浏览
    ResearchEntity getResearchInfo(String uuid);
    //删除
    void delResearch(String uuid);
}
