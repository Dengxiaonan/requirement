package com.xian.requireproject.service.requireset;

import com.xian.requireproject.repository.requireset.entity.RequireSetEntity;

import java.util.List;
import java.util.Map;

public interface RequireSetService {


    List<RequireSetEntity> getRequireSetList(Map<String, Object> param);

}
