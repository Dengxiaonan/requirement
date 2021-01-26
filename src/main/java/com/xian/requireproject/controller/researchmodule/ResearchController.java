package com.xian.requireproject.controller.researchmodule;

import com.xian.requireproject.common.remind.JsonResult;
import com.xian.requireproject.service.researchmodule.ResearchService;
import com.xian.requireproject.service.researchmodule.request.ResearchRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(value = "requireApplicant",tags={"需求-研发组件管理"})
@RestController
@RequestMapping("/require/req")
public class ResearchController {
    @Resource
    ResearchService researchService;

    @ApiOperation(value="添加", produces = "application/json")
    @PostMapping("/addResearch")
    public JsonResult addProjectMainInfoOrType(@RequestBody ResearchRequest researchRequest) {

        researchService.addResearch(researchRequest);

        return JsonResult.success("OK");
    }
    @ApiOperation(value = "分页查询列表", produces = "application/json")
    @PostMapping(value = "/getResearchList/{uuid}", produces = "application/json")
    public JsonResult getResearchList(@PathVariable("uuid") String uuid, @ModelAttribute(name = "page") int p, @ModelAttribute(name = "count") int c) {

        return JsonResult.success(researchService.getResearchList(uuid,p,c));
    }
    @ApiOperation(value="浏览单条信息",produces = "application/json")
    @PostMapping("/getResearchInfo/{uuid}")
    public JsonResult getResearchInfo(@PathVariable("uuid") String uuid){
        return  JsonResult.success(researchService.getResearchInfo(uuid));
    }
    @ApiOperation(value="删除",produces = "application/json")
    @PostMapping("/delResearch/{uuid}")
    public JsonResult delResearch(@PathVariable("uuid") String uuid){
        researchService.delResearch(uuid);
        return JsonResult.success("OK");
    }
}
