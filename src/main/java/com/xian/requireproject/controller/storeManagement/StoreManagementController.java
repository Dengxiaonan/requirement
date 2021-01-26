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

    @ApiOperation(value = "新增仓库", produces = "application/json")
    @PostMapping("/addStoreManagement")
    public JsonResult addStoreManagement(@RequestBody StoreManagementRequest storeManagementRequest) {
      try {

          return JsonResult.success(storeManagementService.addStoreManagement(storeManagementRequest));
      }catch (Exception e){
          return JsonResult.error("401","新增仓库错误");
      }

    }

    @ApiOperation(value = "删除", produces = "application/json")
    @PostMapping("/delStoreManagement/{warehouse}")
    public JsonResult delStoreManagement(@PathVariable("warehouse") String warehouse) {

        storeManagementService.delStoreManagement(warehouse);

        return JsonResult.success("OK");
    }

    @ApiOperation(value = "编辑", produces = "application/json")
    @PostMapping("/updStoreManagement")
    public JsonResult updStoreManagement(@RequestBody StoreManagementRequest storeManagementRequest) {

        storeManagementService.updStoreManagement(storeManagementRequest);

        return JsonResult.success("OK");
    }

    @ApiOperation(value = "查询列表", produces = "application/json")
    @PostMapping(value = "/getUserList/{warehouse}", produces = "application/json")
    public JsonResult getStoreManagementList(@PathVariable("warehouse") String warehouse) {

        return JsonResult.success(storeManagementService.getStoreManagementList(warehouse));
    }

}
