package com.xian.requireproject.controller.processManagement;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xian.requireproject.common.remind.JsonResult;
import com.xian.requireproject.service.processManagement.ProcessManageService;
import com.xian.requireproject.service.processManagement.request.ProcessManageRequest;
import com.xian.requireproject.service.requireapplicant.request.RequireRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(value = "process",tags ={"过程管理"})
@RestController
@RequestMapping("/require/process")
public class ProcessManagementController {
    @Resource
    ProcessManageService processManageService;
    @GetMapping("/getProcess")
    @ApiOperation(value = "过程管理-分页查询条件列表", produces = "application/json")
    public JsonResult getProcess(@RequestParam(value = "requireType" , required = false) String requireType,
                                 @RequestParam(value = "subjectTerm" , required = false) String subjectTerm,
                                 @RequestParam(value = "person" , required = false) String person,
                                 @RequestParam(value = "pageNum" , required = false, defaultValue = "1") Integer pageNum,
                                 @RequestParam(value = "pageSize" , required = false, defaultValue = "10") Integer pageSize){
        RequireRequest requireRequest = new RequireRequest();
        requireRequest.setRequireType(requireType);
        requireRequest.setSubjectTerm(subjectTerm);
        PageHelper.startPage(pageNum, pageSize);
        List<RequireRequest> process = processManageService.getProcess(requireRequest);
        PageInfo<RequireRequest> pageInfo = new PageInfo<RequireRequest>(process);
        return  JsonResult.success(pageInfo);
    }

    @ApiOperation(value = "过程管理-浏览", produces = "application/json")
    @PostMapping("/getProcessInfo/{uuid}")
    public JsonResult getProcessInfo(@PathVariable("uuid") String uuid){
        return JsonResult.success(processManageService.getProcessInfo(uuid));
    }

    @ApiOperation(value = "过程管理-过程", produces = "application/json")
    @PostMapping("/getQueryProcess/{uuid}")
    public JsonResult getQueryProcess(@PathVariable("uuid") String uuid){
        return JsonResult.success(processManageService.getQueryProcess(uuid));
    }
    @ApiOperation(value = "过程管理-删除", produces = "application/json")
    @PostMapping("/delProcess/{uuid}")
    public JsonResult delProcess(@PathVariable("uuid") String uuid) {
        processManageService.delProcess(uuid);
        return JsonResult.success("OK");
    }
}