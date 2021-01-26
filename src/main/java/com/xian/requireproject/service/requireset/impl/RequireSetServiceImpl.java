package com.xian.requireproject.service.requireset.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xian.requireproject.repository.requireapplicant.mapper.RequireMapper;
import com.xian.requireproject.repository.requireset.entity.RequireSetEntity;
import com.xian.requireproject.repository.requireset.mapper.RequireSetMapper;
import com.xian.requireproject.service.requireapplicant.request.RequireRequest;
import com.xian.requireproject.service.requireset.RequireSetService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author zw
 * @Date 2021/1/13 18:05
 */
@Service
public class RequireSetServiceImpl implements RequireSetService {

    @Resource
    RequireSetMapper requireSetMapper;

    @Override
    public List<RequireSetEntity> getRequireSetList(Map<String, Object> param) {
        return requireSetMapper.getRequireSetList(param);
    }
}
