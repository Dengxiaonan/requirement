package com.xian.requireproject.controller.logManagement;

import com.xian.requireproject.common.remind.JsonResult;
import com.xian.requireproject.service.logManagement.LogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(value="LogManagement",tags={"系统管理-日志管理"})
@RestController
@RequestMapping("/require/log")
public class LogController {
    @Resource
    LogService logService;
    @ApiOperation(value = "分页查询列表", produces = "application/json")
    @PostMapping(value = "/getLogList/{uuid}", produces = "application/json")
    public JsonResult getLogList(@PathVariable("uuid") String uuid, @ModelAttribute(name = "page") int p, @ModelAttribute(name = "count") int c) {

        return JsonResult.success(logService.getLogList(uuid,p,c));
    }
    /*@ApiOperation(value="详情",produces = "application/json")
    @PostMapping("/getLogInfo/{uuid}")
    public JsonResult getLogInfo(@PathVariable("uuid") String uuid){
        return  JsonResult.success(logService.getLogInfo(uuid));
    }*/
    @ApiOperation(value="删除",produces = "application/json" )
    @PostMapping("/delLog/{uuid}")
    public JsonResult delLog(@PathVariable("uuid") String uuid){
        logService.delLog(uuid);
        return  JsonResult.success("OK");
    }
    @ApiOperation(value="清空",produces = "application/json")
    @PostMapping("/delLogInfo")
    public JsonResult delLogInfo(){
        logService.delLogInfo();
        return JsonResult.success("OK");
    }

}
