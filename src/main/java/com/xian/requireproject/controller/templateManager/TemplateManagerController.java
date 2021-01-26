package com.xian.requireproject.controller.templateManager;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xian.requireproject.common.UseDetailsDTO;
import com.xian.requireproject.common.UserUtil;
import com.xian.requireproject.common.remind.JsonResult;
import com.xian.requireproject.enums.TempManStatusEnum;
import com.xian.requireproject.repository.sysuser.entity.SysUserEntity;
import com.xian.requireproject.repository.templateManager.entity.TemplateManagerEntity;
import com.xian.requireproject.service.templateManager.TemplateManagerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "tem", tags={"需求分析管理-需求模板管理"})
@RestController
@RequestMapping("/require/template")

public class TemplateManagerController {
    @Resource
    private TemplateManagerService templateManagerService;

    @ApiOperation(value = "需求模板管理-查询列表")
    @PostMapping(value = "/getTemplateManagerList")
    public JsonResult getTemplateManagerList(@RequestParam(value = "tempFileName" , required = false) String tempFileName,
                                             @RequestParam(value = "tempType" , required = false) String tempType,
                                             @RequestParam(value = "pageNum" , required = false, defaultValue = "1") Integer pageNum,
                                             @RequestParam(value = "pageSize" , required = false, defaultValue = "10") Integer pageSize,
                                             HttpServletRequest request) {
        Map<String, Object> param = new HashMap<String, Object>();
        UseDetailsDTO useDetailsDTO = UserUtil.getUserDTO(request);
        param.put("areaId", useDetailsDTO.getAreaId());
        param.put("tempFileName", tempFileName);
        param.put("tempType", tempType);
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String, Object>> list = templateManagerService.getTemplateManagerList(param);
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
        return JsonResult.success(pageInfo);
    }

    @ApiOperation(value = "需求-删除", produces = "application/json")
    @PostMapping("/delTemplateManager/{uuid}")
    public JsonResult delTemplateManager(@PathVariable("uuid") String uuid) {

        templateManagerService.delTemplateManager(uuid);

        return JsonResult.success("OK");
    }
    @ApiOperation(value="详情",produces = "application/json")
    @PostMapping("/getTemplateManagerInfo/{uuid}")
    public JsonResult getTemplateManagerInfo(@PathVariable("uuid") String uuid){
        return JsonResult.success(templateManagerService.getTemplateManagerInfo(uuid));
    }

    @ApiOperation(value = "需求模板-创建模板", produces = "application/json")
    @PostMapping("/addTemplateManager")
    public JsonResult addTemplateManager(@RequestParam(value = "tempType" , required = true) String tempType,
                                         @RequestParam(value = "tempRemark" , required = false) String tempRemark,
                                         @RequestParam(value = "tempFileName" , required = false) MultipartFile file,
                                        HttpServletRequest request) {
        UseDetailsDTO useDetailsDTO = UserUtil.getUserDTO(request);
        TemplateManagerEntity entity = new TemplateManagerEntity();
        Date date  = new Date();
        entity.setTempFileName("test文件");
        entity.setTempType(tempType);
        entity.setTempStatus(TempManStatusEnum.NOT_DEL.getCode());
        entity.setCreateBy(Integer.valueOf(useDetailsDTO.getUserId()));
        entity.setCreateTime(date);
        entity.setUpdateTime(date);
        entity.setAreaId(useDetailsDTO.getAreaId());
        entity.setTempRemark(tempRemark);
        entity.setTempFilePath("D://asdfas//");
        templateManagerService.addTemplateManager(entity);

        return JsonResult.success("OK");
    }
}
