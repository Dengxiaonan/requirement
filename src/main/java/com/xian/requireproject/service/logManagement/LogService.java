package com.xian.requireproject.service.logManagement;

import com.xian.requireproject.repository.logManagement.entity.LogEntity;

import java.util.List;


public interface LogService {

    //分页列表查询
    List<LogEntity> getLogList(LogEntity logEntity);
    //详细信息
    //LogEntity getLogInfo(String uuid);

    //删除
    void delLog(String logid);

    //清空，也可以用状态，使它不显示
    void delLogInfo();
/*
   //记录登录日志
    void saveLog();*/
}
