package com.xian.requireproject.controller.documentRelease;

import com.xian.requireproject.common.remind.JsonResult;
import com.xian.requireproject.service.documentRelease.DocumentReleaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(value="rel",tags = {"需求-文档发布"} )
@RestController
@RequestMapping("/require/release")
public class DocumentReleaseController {
    @Resource
    private DocumentReleaseService documentReleaseService;

    @ApiOperation(value = "需求-分页查询列表", produces = "application/json")
    @PostMapping(value = "/getDocumentReleaseList/{uuid}", produces = "application/json")
    public JsonResult getDocumentReleaseList(@PathVariable("uuid") String uuid, @ModelAttribute(name = "page") int p, @ModelAttribute(name = "count") int c) {

        return JsonResult.success(documentReleaseService.getDocumentReleaseList(uuid,p,c));
    }

    @ApiOperation(value = "需求-详情", produces = "application/json")
    @PostMapping("/getDocumentReleaseInfo/{uuid}")
    public JsonResult getDocumentReleaseInfo(@PathVariable("uuid") String uuid) {

        return JsonResult.success(documentReleaseService.getDocumentReleaseInfo(uuid));
    }

}
