package com.xian.requireproject.service.storeManagement;

import com.xian.requireproject.service.storeManagement.request.StoreManagementRequest;

public interface StoreManagementService {
    // 添加信息
    Object addStoreManagement(StoreManagementRequest storeManagementRequest);
    // 修改信息
    void updStoreManagement(StoreManagementRequest storeManagementRequest);
    // 删除信息
    void delStoreManagement(String warehouse);
    //获取列表
    Object getStoreManagementList(String warehouse);

}
