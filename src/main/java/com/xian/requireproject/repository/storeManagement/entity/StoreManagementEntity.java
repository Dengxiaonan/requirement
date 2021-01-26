package com.xian.requireproject.repository.storeManagement.entity;

import lombok.Data;

@Data
public class StoreManagementEntity {
    private String uuid;
    private String warehouse;
    private String resourceCategories;
    private String systemNumber;
    private String systemName;
    private String brief;
    private String column;
    private String warehouseLocation;
    private String warehouseType;

}
