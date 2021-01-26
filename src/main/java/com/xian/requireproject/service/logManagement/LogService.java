package com.xian.requireproject.service.logManagement;

import com.xian.requireproject.repository.logManagement.entity.LogEntity;


public interface LogService {

    //获取列表信息
    Object getLogList(String uuid,int p, int c);

    //详细信息
    LogEntity getLogInfo(String uuid);
    //删除
    void delLog(String uuid);
    //清空，也可以用状态，使它不显示
    void delLogInfo();


}
