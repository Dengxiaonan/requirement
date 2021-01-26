package com.xian.requireproject.service.sysuser.impl;

import com.alibaba.fastjson.JSON;
import com.xian.requireproject.common.MapperUtils;
import com.xian.requireproject.common.UseDetailsDTO;
import com.xian.requireproject.common.exception.AuthCodeConstant;
import com.xian.requireproject.common.redis.RedisUtil;
import com.xian.requireproject.common.remind.JsonResult;
import com.xian.requireproject.repository.sysuser.entity.SysUserEntity;
import com.xian.requireproject.repository.sysuser.mapper.SysUserMapper;
import com.xian.requireproject.service.sysuser.SysUserService;
import com.xian.requireproject.service.sysuser.request.SysUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


/**
 * @Author ldy
 * @Descriptions 管理员用户接口实现类
 * @Date 2020/11/25 11:13
 * @Version: V1.0
 **/
@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    SysUserMapper sysUserMapper;

    @Resource
    RedisUtil redisUtil;

    @Resource
    PasswordEncoder passwordEncoder;

    @Autowired
    private HttpServletRequest request;

    /**
     * @Author ldy
     * @Description 获取登录用户token信息 如果用户账号密码正确，则用UUID生成唯一编码存入缓存，返回给前端。
     * @Date 2020/11/25 14:10
     * @Param userName
     * @Return token
     **/
    @Override
    public JsonResult userLogin(String userName, String password ) {

        SysUserEntity sysUser = sysUserMapper.loginAuthentication(userName);

        if (null == sysUser) {
            return JsonResult.error("100", "账户信息不存在！！！");
        }
        if (sysUser.getStatus() == 1){
            return JsonResult.error("102", "账户已停用！！！");
        }
        if (!passwordEncoder.matches(password, sysUser.getPassword())) {
            return JsonResult.error("101", "用户名密码不对");
        }
       // authCodeUtil.checkLog(sysUser.getUuid());
       // 此数据为拦截器一存入的数据
        //此数据为拦截器一存入的数据
        UseDetailsDTO useDetailsDTO = new UseDetailsDTO();
        useDetailsDTO.setUserId(sysUser.getUuid());
        useDetailsDTO.setMobile(sysUser.getUserName());
        useDetailsDTO.setStatus(0);
        useDetailsDTO.setAreaId(sysUser.getAreaId());
        //存储用户登录状态  是否在线
        redisUtil.set(AuthCodeConstant.AUTH_CODE_LOGIN_SAVE+sysUser.getUuid(),request.getHeader(AuthCodeConstant.AUTH_HEADER_KEY));
        //存储radis  用户信息
        redisUtil.set(AuthCodeConstant.AUTH_CODE_SAVE+request.getHeader(AuthCodeConstant.AUTH_HEADER_KEY), JSON.toJSONString(useDetailsDTO));
        //更新登陆时间
        return JsonResult.success(sysUser);

    }

    /**
     * @Author ldy
     * @Description 添加用户信息
     * @Date 2020/11/25 14:38
     * @Param sysUserRequest
     **/
    @Override
    public void addSysUser(SysUserEntity sysUserEntity) {
        sysUserMapper.addSysUser(sysUserEntity);
    }

    /**
     * @Author zw
     * @Description 修改用户信息
     * @Date 2020/11/25 17:21
     **/
    @Override
    public void updateUserInfo(SysUserEntity sysUserEntity) {
        sysUserMapper.updateUserInfo(sysUserEntity);
    }

    /**
     * @Author ldy
     * @Description 删除用户信息
     * @Date 2020/11/25 17:24
     **/
    @Override
    public void delSysUser(Integer uuid) {

        sysUserMapper.delSysUser(uuid);
    }

    /**
     * @Author ldy
     * @Description 获取用户信息列表
     * @Date 2020/11/25 17:26
     **/
    @Override
    public List<SysUserEntity> getUserList(Map<String, Object> param) {
        return sysUserMapper.getUserList(param);
    }

    /**
     * @Author ldy
     * @Description 根据用户名获取 用户信息
     * @Date 2020/11/25 18:04
     **/
    @Override
    public SysUserEntity getUserInfo(String userName) {

        return sysUserMapper.getUserInfo(userName);
    }

    @Override
    public SysUserEntity queryUserInfoById(Integer uuid) {

        return sysUserMapper.queryUserInfoById(uuid);
    }

}
