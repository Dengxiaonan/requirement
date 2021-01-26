package com.xian.requireproject.controller.documentsearch;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xian.requireproject.common.UseDetailsDTO;
import com.xian.requireproject.common.UserUtil;
import com.xian.requireproject.common.remind.JsonResult;
import com.xian.requireproject.repository.requireapplicant.entity.CommentEntity;
import com.xian.requireproject.service.documentsearch.DocumentSearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value="doc",tags={"需求分析管理-文档搜索"} )
@RestController
@RequestMapping("/require/doc")
public class DocumentSearchController {
    @Resource
    private DocumentSearchService documentsearchService;

    @ApiOperation(value = "需求分析管理-文档搜索-查询列表",httpMethod = "POST")
    @PostMapping(value = "/getDocumentSearchList")
    public JsonResult getDocumentSearchList(@RequestParam(value = "uuid" , required = false) String uuid,
                                            @RequestParam(value = "number" , required = false) String number,
                                            @RequestParam(value = "projectName" , required = false) String projectName,
                                            @RequestParam(value = "requireFileName" , required = false) String requireFileName,
                                            @RequestParam(value = "person" , required = false) String person,
                                            @RequestParam(value = "pageNum" , required = false, defaultValue = "1") Integer pageNum,
                                            @RequestParam(value = "pageSize" , required = false, defaultValue = "10") Integer pageSize,
                                            HttpServletRequest request) {

        UseDetailsDTO user = UserUtil.getUserDTO(request);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("areaId", user.getAreaId());    // 区域id
        paramMap.put("number", number);              // 项目编号
        paramMap.put("projectName", projectName);    // 项目名称
        paramMap.put("requireFileName", requireFileName);// 文件名称
        paramMap.put("person", person);              // 发布人
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String, Object>> list = documentsearchService.getDocumentSearchList(paramMap);
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
        return JsonResult.success(pageInfo);
    }
    @ApiOperation(value="浏览",produces = "application/json")
    @PostMapping(value="/getDocumentInfo/{uuid}")
    public JsonResult getDocumentInfo(@PathVariable("uuid") String uuid){
        return JsonResult.success(documentsearchService.getDocumentInfo(uuid));

    }




}
