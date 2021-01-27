package com.xian.requireproject.service.logManagement.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xian.requireproject.repository.logManagement.entity.LogEntity;
import com.xian.requireproject.repository.logManagement.mapper.LogMapper;
import com.xian.requireproject.service.logManagement.LogService;
import com.xian.requireproject.service.logManagement.request.LogRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class LogServiceImpl implements LogService {

    @Resource
    LogMapper logMapper;

    @Override
    public Object getLogList(String uuid, int p, int c) {

        Page<LogEntity> objects = PageHelper.startPage(p, c);
        List<LogEntity> logList = logMapper.getLogList(uuid);
        PageInfo<LogEntity> objectPageInfo = new PageInfo<>(logList);

        return objectPageInfo;
    }

    /*@Override
    public LogEntity getLogInfo(String uuid) {

        return logMapper.getLogInfo(uuid);
    }*/

    @Override
    public void delLog(String uuid) {
       logMapper.delLog(uuid);
    }
   //清空列表信息
    @Override
    public void delLogInfo() {
        logMapper.delLogInfo();
    }
}
