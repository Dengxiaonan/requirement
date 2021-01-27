package com.xian.requireproject.controller.storeManagement;

import com.xian.requireproject.common.remind.JsonResult;
import com.xian.requireproject.service.storeManagement.StoreManagementService;
import com.xian.requireproject.service.storeManagement.request.StoreManagementRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(value = "store",tags={"仓库管理"})
@RestController
@RequestMapping("/require/store")
public class StoreManagementController {
    @Resource
    StoreManagementService storeManagementService;



    @ApiOperation(value = "删除", produces = "application/json")
    @PostMapping("/delStoreManagement/{warehouse_id}")
    public JsonResult delStoreManagement(@PathVariable("warehouse_id") String warehouse_id) {

        storeManagementService.delStoreManagement(warehouse_id);

        return JsonResult.success("OK");
    }


    @ApiOperation(value = "查询列表", produces = "application/json")
    @PostMapping(value = "/getUserList/{warehouse_id}", produces = "application/json")
    public JsonResult getStoreManagementList(@PathVariable("warehouse") String warehouse_id) {

        return JsonResult.success(storeManagementService.getStoreManagementList(warehouse_id));
    }

}
