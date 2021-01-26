package com.xian.requireproject.controller.role;

import com.xian.requireproject.common.UseDetailsDTO;
import com.xian.requireproject.common.UserUtil;
import com.xian.requireproject.common.redis.RedisUtil;
import com.xian.requireproject.common.remind.JsonResult;
import com.xian.requireproject.service.role.MenuService;
import com.xian.requireproject.service.role.dao.Role;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


/**
 * @author danyang.liao
 */
@RestController
@CrossOrigin
@Api(value = "/menu", tags={ "权限菜单相关接口"})
@RequestMapping("/require/menu/v1")
public class MenuController {
    private static Logger logger = LoggerFactory.getLogger(MenuController.class);

    @Autowired
    private MenuService menuService;

    @Autowired
    private HttpServletRequest request;
    @Resource
    RedisUtil redisUtil;

    /**
     *获取所有菜单
     * @return
     */
    @GetMapping("/menu/list")
    @ApiOperation(value = "获取所有菜单",notes = "获取所有菜单",httpMethod = "GET",response = Role.class)
    public JsonResult getMenuListAll(HttpServletRequest request) {
    UseDetailsDTO useDetailsDTO = UserUtil.getUserDTO(request);
//        Object userID = redisUtil.get("userID");
        return JsonResult.success(menuService.getMenuList( useDetailsDTO.getUserId()));
    }


}
