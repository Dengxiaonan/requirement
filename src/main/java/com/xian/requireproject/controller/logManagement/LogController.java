package com.xian.requireproject.controller.logManagement;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xian.requireproject.common.remind.JsonResult;
import com.xian.requireproject.repository.logManagement.entity.LogEntity;
import com.xian.requireproject.service.logManagement.LogService;
import com.xian.requireproject.service.requireapplicant.request.RequireRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value="LogManagement",tags={"系统管理-日志管理"})
@RestController
@RequestMapping("/require/log")
public class LogController {
    @Resource
    LogService logService;
    @ApiOperation(value = "日志分页查询列表-条件", produces = "application/json")
    @PostMapping(value = "/getLogList/{uuid}", produces = "application/json")
    public JsonResult getLogList(@RequestParam(value = "login_name" , required = false) String loginname,
                                 @RequestParam(value = "details" , required = false) String details,
                                 @RequestParam(value = "operation_startime" , required = false) String startime,
                                 @RequestParam(value = "operation_endtime" , required = false) String endtime,
                                 @RequestParam(value = "pageNum" , required = false, defaultValue = "1") Integer pageNum,
                                 @RequestParam(value = "pageSize" , required = false, defaultValue = "10") Integer pageSize) {
        LogEntity logEntity = new LogEntity();
        logEntity.setLoginName(loginname);
        logEntity.setDetails(details);
        logEntity.setStartime(startime);
        logEntity.setEndtime(endtime);
        PageHelper.startPage(pageNum, pageSize);
        List<LogEntity> logList = logService.getLogList(logEntity);
        PageInfo<LogEntity> pageInfo = new PageInfo<LogEntity>(logList);
        return JsonResult.success(pageInfo);
    }

    @ApiOperation(value="删除",produces = "application/json" )
    @PostMapping("/delLog/{logid}")
    public JsonResult delLog(@PathVariable("logid") String logid){
        logService.delLog(logid);
        return  JsonResult.success("OK");
    }
    @ApiOperation(value="清空",produces = "application/json")
    @PostMapping("/delLogInfo")
    public JsonResult delLogInfo(){
        logService.delLogInfo();
        return JsonResult.success("OK");
    }

}
