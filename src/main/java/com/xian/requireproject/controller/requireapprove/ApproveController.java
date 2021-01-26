package com.xian.requireproject.controller.requireapprove;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xian.requireproject.common.UseDetailsDTO;
import com.xian.requireproject.common.UserUtil;
import com.xian.requireproject.common.remind.JsonResult;
import com.xian.requireproject.enums.RequireStatusEnum;
import com.xian.requireproject.repository.requireapprove.entity.ApproveEntity;
import com.xian.requireproject.service.requireapplicant.request.RequireRequest;
import com.xian.requireproject.service.requireapprove.ApproveService;
import com.xian.requireproject.service.requireapprove.request.ApproveRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "requireapprove",tags={"需求-需求审批"})
@RestController
@RequestMapping("/require/req")
public class ApproveController {

    @Resource
    ApproveService approveService;

    @ApiOperation(value = "审批提交", produces = "application/json")
    @PostMapping("/approveCommit")
    public JsonResult approveCommit(@RequestParam(value = "uuid", required = true) String uuid,
                                    @RequestParam(value = "status", required = true) Integer status,
                                    @RequestParam(value = "cause", required = false) String cause,
                                    HttpServletRequest request) {

        if (RequireStatusEnum.ALREADY_APPROVE.getCode() != status
            && RequireStatusEnum.ALREADY_BACK.getCode() != status
            && RequireStatusEnum.REFUSE.getCode() != status) {
            return JsonResult.error("500", "审批提交状态错误！");
        }
        UseDetailsDTO user = UserUtil.getUserDTO(request);

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("uuid", uuid);
        param.put("status", status);
        param.put("examine", user.getUserId());
        param.put("updateTime", new Date());
        if (RequireStatusEnum.ALREADY_BACK.getCode() == status) {
            param.put("requireBackCause", cause);
        } else if (RequireStatusEnum.REFUSE.getCode() == status) {
            param.put("requireRefCause", cause);
        }
        approveService.approveCommit(param);

        return JsonResult.success("OK");
    }
    @ApiOperation(value = "删除", produces = "application/json")
    @PostMapping("/delApprove/{uuid}")
    public JsonResult delRequire(@PathVariable("uuid") String uuid) {

        approveService.delApprove(uuid);

        return JsonResult.success("OK");
    }

    @ApiOperation(value = "修改提交", produces = "application/json")
    @PostMapping("/updApprove")
    public JsonResult updSysUser(@RequestBody ApproveRequest approveRequest) {

        approveService.updApprove(approveRequest);

        return JsonResult.success("OK");
    }

    @ApiOperation(value = "分页查询列表", httpMethod = "GET")
    @GetMapping(value = "/getApproveList", produces = "application/json")
    public JsonResult getApproveList(@RequestParam(value = "pageNum" , required = false, defaultValue = "1") Integer pageNum,
                                     @RequestParam(value = "pageSize" , required = false, defaultValue = "10") Integer pageSize,
                                     @RequestParam(value = "number" , required = false) String number,
                                     @RequestParam(value = "subjectTerm" , required = false) String subjectTerm,
                                     @RequestParam(value = "statuss" , required = false) String statuss,
                                     HttpServletRequest request) {

        UseDetailsDTO useDetailsDTO = UserUtil.getUserDTO(request);


        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("number", number);// 系统编号
        paramMap.put("subjectTerm", subjectTerm);// 主题词
        paramMap.put("areaId", useDetailsDTO.getAreaId());// 区域id
        paramMap.put("statuss", statuss);// 状态

        PageHelper.startPage(pageNum, pageSize);
        List<RequireRequest> list = approveService.getApproveList(paramMap);
        PageInfo pageInfo = new PageInfo(list);
        return JsonResult.success(pageInfo);
    }

    @ApiOperation(value = "详情", produces = "application/json")
    @PostMapping("/getApproveInfo/{uuid}")
    public JsonResult getApproveInfo(@PathVariable("uuid") String uuid) {

        return JsonResult.success(approveService.getApproveInfo(uuid));
    }

}