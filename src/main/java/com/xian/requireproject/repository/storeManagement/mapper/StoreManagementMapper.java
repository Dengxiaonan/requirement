package com.xian.requireproject.repository.storeManagement.mapper;

import com.xian.requireproject.repository.storeManagement.entity.StoreManagementEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StoreManagementMapper {
    /**
     * 添加
     * @param storeManagementEntity
     */
    @Insert("INSERT INTO store_management(`warehouse`,`brief`,`warehouse_location`,`warehouse_type`) " +
            "VALUES (#{warehouse},#{brief},#{warehouseLocation},#{warehouseType})")
    void addStoreManagement(StoreManagementEntity storeManagementEntity);

    /**
     * @Author ldy
     * @Description 修改
     * @Date 2020/11/25 17:54
     **/
    @Update("UPDATE store_management SET `uuid` = #{uuid},`warehouse` = #{warehouse},`resource_categories` = #{resourceCategories}," +
            "`system_number` = #{systemNumber},`brief` = #{brief},`warehouse_location` = #{warehouseLocation}," +
            "`warehouse_type` = #{warehouseType} where warehouse = #{warehouse} ")
    void updStoreManagement(StoreManagementEntity storeManagementEntity);

    /**
     * @Author ldy
     * @Description 根据账号删除用户信息
     * @Date 2020/11/25 17:55
     **/
    @Delete("delete from store_management where uuid = #{uuid}")
    void delStoreManagement(@Param("uuid") String uuid);

    /**
     * @Author ldy
     * @Description 获取用户信息列表
     * @Date 2020/11/25 17:56
     **/
    @Select("SELECT * FROM store_management m WHERE m.uuid = #{uuid}")
    List<StoreManagementEntity> getStoreManagementList(@Param("uuid") String uuid);




}
