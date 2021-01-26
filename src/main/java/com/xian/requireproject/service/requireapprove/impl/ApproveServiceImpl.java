package com.xian.requireproject.service.requireapprove.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xian.requireproject.common.MapperUtils;
import com.xian.requireproject.common.UUIDUtils;
import com.xian.requireproject.repository.requireapprove.entity.ApproveEntity;
import com.xian.requireproject.repository.requireapprove.mapper.ApproveMapper;

import com.xian.requireproject.service.requireapplicant.request.RequireRequest;
import com.xian.requireproject.service.requireapprove.ApproveService;
import com.xian.requireproject.service.requireapprove.request.ApproveRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service
public class ApproveServiceImpl implements ApproveService {

    @Resource
    ApproveMapper approveMapper;

    @Override
    public void approveCommit(Map<String, Object> param) {
        approveMapper.approveCommit(param);

    }


    @Override
    public void updApprove(ApproveRequest approveRequest) {
        ApproveEntity approveEntity = MapperUtils.mapperBean(approveRequest, ApproveEntity.class);

        approveMapper.updApprove(approveEntity);
    }


    @Override
    public void delApprove(String uuid) {
        approveMapper.delApprove(uuid);
    }

    @Override
    public List<RequireRequest> getApproveList(Map<String, Object> param) {
        return approveMapper.getApproveList(param);
    }

    @Override
    public RequireRequest getApproveInfo(String uuid) {

        return approveMapper.getByIdApproveInfo(uuid);
    }

}
