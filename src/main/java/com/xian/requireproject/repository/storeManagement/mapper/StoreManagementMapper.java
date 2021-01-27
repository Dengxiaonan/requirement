package com.xian.requireproject.repository.storeManagement.mapper;

import com.xian.requireproject.repository.storeManagement.entity.StoreManagementEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StoreManagementMapper {

    /**
     * @Author ldy
     * @Description 删除上传的zip压缩包
     * @Date 2021/01/27 17:55
     **/
    @Delete("delete from store_management where warehouse_files_id = #{warehouseFilesId}")
    void delStoreManagement(@Param("warehouse_files_id") String warehouse_files_id);

    /**
     * @Author ldy
     * @Description 获取仓库信息列表
     * @Date 2021/01/27 17:56
     **/
    @Select("SELECT * FROM store_management s left join warehouse_files w on s.warehouse_files_id = w.warehouse_files_id")
    List<StoreManagementEntity> getStoreManagementList(@Param("warehouse_id") String warehouse_id);



}
