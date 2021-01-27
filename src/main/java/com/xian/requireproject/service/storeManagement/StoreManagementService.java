package com.xian.requireproject.service.storeManagement;

import com.xian.requireproject.service.storeManagement.request.StoreManagementRequest;

public interface StoreManagementService {

    // 删除信息
    void delStoreManagement(String warehouse_files_id);
    //获取列表
    Object getStoreManagementList(String warehouse_id);

}
