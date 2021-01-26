package com.xian.requireproject.service.processManagement.impl;

import com.xian.requireproject.common.MapperUtils;
import com.xian.requireproject.common.UUIDUtils;
import com.xian.requireproject.repository.processManagement.entity.ProcessManageEntity;
import com.xian.requireproject.repository.processManagement.mapper.ProcessManageMapper;
import com.xian.requireproject.service.processManagement.ProcessManageService;
import com.xian.requireproject.service.processManagement.request.ProcessManageRequest;
import com.xian.requireproject.service.requireapplicant.request.RequireRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ProcessManageServiceImpl implements ProcessManageService {
@Resource
private ProcessManageMapper processManageMapper;

    @Override
    public List<RequireRequest> getProcess(RequireRequest requireRequest) {
        return  processManageMapper.getProcess(requireRequest);
    }

    @Override
    public RequireRequest getProcessInfo(String uuid) {
        return processManageMapper.getProcessInfo(uuid);
    }

    @Override
    public RequireRequest getQueryProcess(String uuid) {
        return processManageMapper.getQueryProcess(uuid);
    }

    @Override
    public void delProcess(String uuid) {
        processManageMapper.delProcess(uuid);
    }
}
