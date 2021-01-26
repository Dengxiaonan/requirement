package com.xian.requireproject.controller.requireset;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xian.requireproject.common.UseDetailsDTO;
import com.xian.requireproject.common.remind.JsonResult;
import com.xian.requireproject.repository.requireapplicant.entity.CommentEntity;
import com.xian.requireproject.repository.requireapprove.entity.ApproveEntity;
import com.xian.requireproject.repository.requireset.entity.RequireSetEntity;
import com.xian.requireproject.service.requireapplicant.RequireService;
import com.xian.requireproject.service.requireapplicant.request.RequireRequest;
import com.xian.requireproject.service.requireset.RequireSetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "requireset", tags={"项目集合"})
@RestController
@RequestMapping("/requireSet")
public class RequireSetController {

    @Resource
    RequireSetService requireSetService;

    @PostMapping("/getRequireSetList")
    @ApiOperation(value = "项目集合分页查询列表", notes = "项目集合分页查询", httpMethod = "POST", response = PageInfo.class)
    public JsonResult getRequireSetList(HttpServletRequest request, @ModelAttribute(name = "pageNum") int pageNum, @ModelAttribute(name = "pageSize") int pageSize) {
        // 获取当前登录用户信息
        UseDetailsDTO useDetailsDTO = (UseDetailsDTO)request.getAttribute("useDetailsDTO");
        String areaId = useDetailsDTO.getAreaId();

        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("areaId", areaId);
        Page<RequireSetEntity> page = PageHelper.startPage(pageNum, pageSize);
        List<RequireSetEntity> requireSetList = requireSetService.getRequireSetList(paramMap);
        PageInfo<RequireSetEntity> pageInfo = new PageInfo<RequireSetEntity>(requireSetList);
        return JsonResult.success(pageInfo);
    }

}