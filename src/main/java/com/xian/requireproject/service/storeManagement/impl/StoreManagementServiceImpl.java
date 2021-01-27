package com.xian.requireproject.service.storeManagement.impl;

import com.xian.requireproject.common.MapperUtils;
import com.xian.requireproject.common.UUIDUtils;
import com.xian.requireproject.repository.storeManagement.entity.StoreManagementEntity;
import com.xian.requireproject.repository.storeManagement.mapper.StoreManagementMapper;
import com.xian.requireproject.service.storeManagement.StoreManagementService;
import com.xian.requireproject.service.storeManagement.request.StoreManagementRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StoreManagementServiceImpl implements StoreManagementService {
@Resource
    StoreManagementMapper storeManagementMapper;

   //删除上传的仓库文件
   @Override
    public void delStoreManagement(String warehouse_files_id) {
        storeManagementMapper.delStoreManagement(warehouse_files_id);
    }
   //获取仓库信息
    @Override
    public Object getStoreManagementList(String warehouse_id) {
        List<StoreManagementEntity> storeManagementList = storeManagementMapper.getStoreManagementList(warehouse_id);
        return storeManagementList;
    }
}
