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

    @Override
    public Object addStoreManagement(StoreManagementRequest storeManagementRequest) {
        StoreManagementEntity storeManagementEntity = MapperUtils.mapperBean(storeManagementRequest, StoreManagementEntity.class);
        storeManagementEntity.setUuid(UUIDUtils.getUUID());
        storeManagementEntity.setWarehouse(storeManagementEntity.getWarehouse());
        storeManagementEntity.setBrief(storeManagementEntity.getBrief());
        storeManagementEntity.setWarehouseLocation(storeManagementEntity.getWarehouseLocation());
        storeManagementEntity.setWarehouseType(storeManagementEntity.getWarehouseType());

        storeManagementMapper.addStoreManagement(storeManagementEntity);
        return storeManagementEntity;
    }

    @Override
    public void updStoreManagement(StoreManagementRequest storeManagementRequest) {
        StoreManagementEntity storeManagementEntity = MapperUtils.mapperBean(storeManagementRequest, StoreManagementEntity.class);

        storeManagementEntity.setWarehouse(storeManagementEntity.getWarehouse());
        storeManagementEntity.setResourceCategories(storeManagementEntity.getResourceCategories());
        storeManagementEntity.setSystemNumber(storeManagementEntity.getSystemNumber());
        storeManagementEntity.setBrief(storeManagementEntity.getBrief());
        storeManagementEntity.setWarehouseLocation(storeManagementEntity.getWarehouseLocation());
        storeManagementEntity.setWarehouseType(storeManagementEntity.getWarehouseType());
        storeManagementMapper.updStoreManagement(storeManagementEntity);

    }


    @Override
    public void delStoreManagement(String warehouse) {
        storeManagementMapper.delStoreManagement(warehouse);
    }

    @Override
    public Object getStoreManagementList(String warehouse) {
        List<StoreManagementEntity> storeManagementList = storeManagementMapper.getStoreManagementList(warehouse);
        return storeManagementList;
    }
}
