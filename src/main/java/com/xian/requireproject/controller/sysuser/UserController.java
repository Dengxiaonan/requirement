package com.xian.requireproject.controller.sysuser;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xian.requireproject.common.AuthCodeUtil;
import com.xian.requireproject.common.HttpUtil;
import com.xian.requireproject.common.UseDetailsDTO;
import com.xian.requireproject.common.UserUtil;
import com.xian.requireproject.common.exception.AuthCodeConstant;
import com.xian.requireproject.common.redis.RedisUtil;
import com.xian.requireproject.common.remind.JsonResult;
import com.xian.requireproject.enums.UserStatusEnum;
import com.xian.requireproject.repository.sysuser.entity.SysUserEntity;
import com.xian.requireproject.service.sysuser.SysUserService;
import com.xian.requireproject.service.sysuser.request.SysUserRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "sysUser",tags = {"系统管理-用户管理"})
@RestController
@RequestMapping("/sysUser")
@CrossOrigin
public class UserController {

    @Resource
    SysUserService sysUserService;

    @Resource
    RedisUtil redisUtil;

    @Resource
    PasswordEncoder passwordEncoder;


    @GetMapping("/get/code")
    @ApiOperation(value = "获取授权码",notes = "获取授权码",httpMethod = "GET",response = String.class)
    public JsonResult getVerification (){
        try {
            // 2.验证通过生成token
            String authCode = AuthCodeUtil.getToken();
            if (authCode == null) {
                return JsonResult.error("301","token生成失败");
            }
            redisUtil.set(AuthCodeConstant.AUTH_CODE_TOKEN+authCode, JSON.toJSONString(new UseDetailsDTO()));

            return JsonResult.success(authCode);
        }catch (Exception e){
            return JsonResult.error("-1","授权码生成错误！！！");
        }
    }

    @ApiOperation(value = "登录", produces = "application/json")
    @PostMapping("/login")
    public JsonResult userLogin(@RequestBody SysUserRequest sysUserRequest ,HttpServletRequest request) {
        JsonResult jsonResult = sysUserService.userLogin(sysUserRequest.getUserName(), sysUserRequest.getPassword(),request);

       // String userIP = HttpUtil.getRealIp(request);
        return jsonResult;
    }

    @ApiOperation(value = "用户管理-新增")
    @PostMapping("/addSysUser")
    public JsonResult addSysUser(@RequestParam(value = "nickName", required = true) String nickName,
                                 @RequestParam(value = "roleId", required = true) String roleId,
                                 @RequestParam(value = "status", required = true) Integer status,
                                 @RequestParam(value = "userName", required = true) String userName,
                                 @RequestParam(value = "password", required = false) String password,
                                 @RequestParam(value = "areaId", required = true) String areaId,
                                 @RequestParam(value = "remark", required = false) String remark,
                                 HttpServletRequest req) {
        try {
            SysUserEntity userInfo = sysUserService.getUserInfo(userName);
            if (null != userInfo) {
                return JsonResult.error("500", "登录用户名已存在");
            }
            if (StringUtils.isBlank(password)) {
                password = "123456";
            }
            UseDetailsDTO useDetailsDTO = UserUtil.getUserDTO(req);
            SysUserEntity request = new SysUserEntity();
            request.setNickName(nickName);// 用戶名称
            request.setRoleId(roleId);// 角色
            request.setStatus(status);// 角色状态
            request.setRemark(remark);// 备注
            request.setUserName(userName);// 登录用户名
            request.setPassword(passwordEncoder.encode(password));// 密码
            request.setDelFlag(UserStatusEnum.NOT_DEL.getCode());// 删除标志
            request.setCreateBy(useDetailsDTO == null? "" : useDetailsDTO.getUserId());// 创建人
            request.setAreaId(areaId);// 区域Id
            request.setCreateTime(LocalDateTime.now());// 创建时间
            request.setUpdateTime(LocalDateTime.now());// 更新时间
            sysUserService.addSysUser(request);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error("500", "用户添加失败！");
        }

        return JsonResult.success("ok");


    }

    @ApiOperation(value = "用户管理-删除提交", produces = "application/json")
    @PostMapping("/delSysUser/{uuid}")
    public JsonResult delSysUser(@PathVariable("uuid") Integer uuid) {
        sysUserService.delSysUser(uuid);
        return JsonResult.success("OK");
    }

    @ApiOperation(value = "用户管理-修改提交", produces = "application/json")
    @PostMapping("/updSysUser")
    public JsonResult updateUserInfo(@RequestBody SysUserEntity sysUserEntity) {
        sysUserService.updateUserInfo(sysUserEntity);
        return JsonResult.success("OK");
    }

    @PostMapping("/getUserList")
    @ApiOperation(value = "用户管理-查询列表",httpMethod = "POST")
    public JsonResult getUserList(@RequestParam(value = "nickName", required = false) String nickName,
                                  @RequestParam(value = "status", required = false) String status,
                                  @RequestParam(value = "pageNum" , required = false, defaultValue = "1") Integer pageNum,
                                  @RequestParam(value = "pageSize" , required = false, defaultValue = "10") Integer pageSize,
                                  HttpServletRequest request) {

        UseDetailsDTO useDetailsDTO = UserUtil.getUserDTO(request);
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("nickName", nickName);
        param.put("status", status);
        param.put("areaId", useDetailsDTO.getAreaId());
        PageHelper.startPage(pageNum, pageSize);
        List<SysUserEntity> userList = sysUserService.getUserList(param);
        PageInfo<SysUserEntity> pageInfo = new PageInfo<SysUserEntity>(userList);
        return JsonResult.success(pageInfo);
    }

    @ApiOperation(value = "用户管理-详情", produces = "application/json")
    @PostMapping("/getUserInfo/{uuid}")
    public JsonResult getUserInfo(@PathVariable("uuid") Integer uuid) {

        return JsonResult.success(sysUserService.queryUserInfoById(uuid));
    }

}
