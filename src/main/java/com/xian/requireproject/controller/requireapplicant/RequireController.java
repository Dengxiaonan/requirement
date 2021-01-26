package com.xian.requireproject.controller.requireapplicant;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xian.requireproject.common.DateUtil;
import com.xian.requireproject.common.UseDetailsDTO;
import com.xian.requireproject.common.UserUtil;
import com.xian.requireproject.common.file.FileUtil;
import com.xian.requireproject.common.remind.JsonResult;
import com.xian.requireproject.repository.requireapplicant.entity.CommentEntity;
import com.xian.requireproject.service.requireapplicant.RequireService;
import com.xian.requireproject.service.requireapplicant.request.RequireRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Api(value = "requireApplicant",tags={"需求-需求申请"})
@RestController
@RequestMapping("/require/req")
public class RequireController {
    @Resource
    RequireService requireService;

    @ApiOperation(value = "添加", produces = "application/json")
    @PostMapping("/addRequire")
    public JsonResult addRequire(@RequestBody RequireRequest requireRequest) {
//    public JsonResult addProjectMainInfoOrType(MultipartFile file, RequireRequest request) {
//        boolean saveFileResult = FileUtil.uploadFile(file);
//        if (!saveFileResult) {
//            JsonResult.error("500", "文件保存失败");
//        }
        requireService.addRequire(requireRequest);

        return JsonResult.success("OK");
    }
    @ApiOperation(value = "删除", produces = "application/json")
    @PostMapping("/delRequire/{uuid}")
    public JsonResult delRequire(@PathVariable("uuid") String uuid) {

        requireService.delRequire(uuid);

        return JsonResult.success("OK");
    }

    @ApiOperation(value = "修改", produces = "application/json")
    @PostMapping("/updRequire")
    public JsonResult updRequire(@RequestBody RequireRequest requireRequest) {

        requireService.updRequire(requireRequest);

        return JsonResult.success("OK");
    }
//
//    @ApiOperation(value = "分页查询列表", produces = "application/json")
//    @PostMapping(value = "/getUserList/{uuid}", produces = "application/json")
//    public JsonResult getUserList(@PathVariable("uuid") String uuid,@ModelAttribute(name = "page") int p, @ModelAttribute(name = "count") int c) {
//
//        return JsonResult.success(requireService.getRequireList(uuid,p,c));
//    }

//    ===============================需求申请列表查询(条件查询)======================================已修改

    @GetMapping("/getRequireList")
    @ApiOperation(value = "需求申请分页查询列表",notes = "需求申请列表分页查询(条件查询)",httpMethod = "GET",response = PageInfo.class)
    public JsonResult getRequireList(@RequestParam(value = "sysNum" , required = false) String sysNum,
                                  @RequestParam(value = "subjectTerm" , required = false) String subjectTerm,
                                  @RequestParam(value = "status" , required = false) Integer status,
                                  @RequestParam(value = "pageNum" , required = false, defaultValue = "1") Integer pageNum,
                                  @RequestParam(value = "pageSize" , required = false, defaultValue = "10") Integer pageSize) {
        RequireRequest requireRequest = new RequireRequest();
        requireRequest.setNumber(sysNum);
        requireRequest.setSubjectTerm(subjectTerm);
        requireRequest.setStatuss(status);
        PageHelper.startPage(pageNum, pageSize);
        List<RequireRequest> requireList = requireService.getRequireList(requireRequest);
        PageInfo<RequireRequest> pageInfo = new PageInfo<RequireRequest>(requireList);
        return JsonResult.success(pageInfo);
    }





//    ======================================================================================================已修改


    //    ===============================需求审批列表查询(条件查询)======================================已修改

    @PostMapping("/getApproveList")
    @ApiOperation(value = "需求审批分页查询列表",notes = "需求审批列表分页查询(条件查询)",httpMethod = "POST",response = PageInfo.class)
    public JsonResult getApproveList(@RequestBody RequireRequest requireRequest) {
        JsonResult a=JsonResult.success(requireService.getApproveList(requireRequest));
        return JsonResult.success(requireService.getApproveList(requireRequest));
    }

    //    ===============================需求辅助分析列表查询(条件查询)======================================已修改

    @PostMapping("/getAssistList")
    @ApiOperation(value = "需求辅助分析分页查询列表",notes = "需求辅助分析列表分页查询(条件查询)",httpMethod = "POST",response = PageInfo.class)
    public JsonResult getAssistList(@RequestBody RequireRequest requireRequest) {
        return JsonResult.success(requireService.getAssistList(requireRequest));
    }
    //    ===============================需求审批列表查询(条件查询)======================================已修改

    @PostMapping("/getDocumentList")
    @ApiOperation(value = "需求文档发布分页查询列表",notes = "需求文档发布列表分页查询(条件查询)",httpMethod = "POST",response = PageInfo.class)
    public JsonResult getDocumentList(@RequestBody RequireRequest requireRequest) {
        JsonResult a=JsonResult.success(requireService.getDocumentList(requireRequest));
        return JsonResult.success(requireService.getDocumentList(requireRequest));
    }

    @ApiOperation(value = "详情", produces = "application/json")
    @PostMapping("/getRequireInfo/{uuid}")
    public JsonResult getRequireInfo(@PathVariable("uuid") String uuid) {

        return JsonResult.success(requireService.getRequireInfo(uuid));
    }

    @ApiOperation(value = "需求申请模块(页面按钮)", produces = "application/json")
    @PostMapping("/submitDemand")
    public JsonResult submitDemand(@RequestBody RequireRequest requireRequest) {

        requireService.submitDemand(requireRequest);

        return JsonResult.success("OK");
    }
    @ApiOperation(value = "需求审批模块审批(审批按钮)", produces = "application/json")
    @PostMapping("/demandExamine")
    public JsonResult demandExamine(@RequestBody RequireRequest requireRequest) {
        if (requireRequest.getStatus() == 4){
            requireService.demandExamines(requireRequest);
            return JsonResult.success("OK");
        }else {
            requireService.demandExamine(requireRequest);

            return JsonResult.success("OK");
        }
    }
    @ApiOperation(value = "需求辅助分析-评论添加" ,  produces = "application/json")
    @PostMapping("/addComment")
    public JsonResult addComment(@RequestBody CommentEntity commentEntity, HttpServletRequest request){
        //这个地方需要添加一个用户的名字因为登录信息没有放所以放好了获取更改
        UseDetailsDTO useDetailsDTO = UserUtil.getUserDTO(request);
        commentEntity.setCommentator(useDetailsDTO.getUserId());
        commentEntity.setEditTime(DateUtil.getDateyyyyMMddHHmmss(new Date()));
        if (commentEntity!=null){
            requireService.addComment(commentEntity);
            return JsonResult.success("OK");
        }
        return JsonResult.success("NO");
    }
    @ApiOperation(value = "需求辅助分析-评论查询" ,  produces = "application/json",httpMethod = "GET")
    @GetMapping("/getComment")
    public JsonResult queryComment(@RequestParam(value = "rid" , required = true) String rid,
            @RequestParam(value = "pageNum" , required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize" , required = false, defaultValue = "10") Integer pageSize){

        PageHelper.startPage(pageNum, pageSize);
        List<CommentEntity> list = requireService.queryComment(rid);
        PageInfo<CommentEntity> objectPageInfo = new PageInfo<CommentEntity>(list);
        if (list.size() <= 0) {
            return JsonResult.error("500", "当前需求还没有评论信息！");
        }
        return JsonResult.success(objectPageInfo);
    }

//    @ApiOperation(value = "获取所有战区信息" ,produces = "application/json")
//    @PostMapping("/getZone")
//    public JsonResult getZone(){
//        try{
//            return JsonResult.success(requireService.getZone());
//        }catch (Exception e){
//            return JsonResult.error("30001","获取所有战区信息错误");
//        }
//    }

    @ApiOperation(value = "获取所有战区信息名称" ,produces = "application/json")
    @PostMapping("/getZoneUser")
    public JsonResult getZoneUser(@PathVariable("userId") String userId){
        try{
            return JsonResult.success(requireService.getZoneUser(userId));
        }catch (Exception e){
            return JsonResult.error("30001","获取所有战区信息错误");
        }
    }
}