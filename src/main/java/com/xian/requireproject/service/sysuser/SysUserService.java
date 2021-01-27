package com.xian.requireproject.service.sysuser;

import com.xian.requireproject.service.sysuser.request.ParamVO;
import com.xian.requireproject.service.sysuser.request.SysUserRequest;
import com.xian.requireproject.common.remind.JsonResult;
import com.xian.requireproject.repository.sysuser.entity.SysUserEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 *
 * 用户信息接口类
 */


public interface SysUserService {

//获取用户登录信息
JsonResult userLogin(String userName, String password, HttpServletRequest request);
// 添加用户信息s
void addSysUser(SysUserEntity sysUserEntity);
// 修改用户信息
void updateUserInfo(SysUserEntity sysUserEntity);
// 删除用户信息
void delSysUser(Integer uuid);
//获取用户信息列表
List<SysUserEntity> getUserList(Map<String, Object> param);
//根据用户名获取 用户信息
SysUserEntity getUserInfo(String userName);
//根据用户名id获取 用户信息
SysUserEntity queryUserInfoById(Integer uuid);

}
