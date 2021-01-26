package com.xian.requireproject.repository.sysuser.mapper;

import com.xian.requireproject.repository.requireapplicant.provider.RequireProvider;
import com.xian.requireproject.repository.sysuser.entity.SysUserEntity;
import com.xian.requireproject.repository.sysuser.provider.SysUserProvider;
import com.xian.requireproject.service.requireapplicant.request.RequireRequest;
import com.xian.requireproject.service.sysuser.request.ParamVO;
import org.apache.ibatis.annotations.*;
import java.util.List;
import java.util.Map;

/**
 * @Author ldy
 * @Descriptions 用户信息sql实现类
 * @Date 2020/11/25 11:48
 * @Version: V1.0
 **/
@Mapper
public interface SysUserMapper {

    /**
     * @Author ldy
     * @Description
     * @Date 2020/11/25 15:26
     * @Param userName
     **/
    @Select("SELECT * FROM sys_user u WHERE u.user_name = #{userName}")
    SysUserEntity loginAuthentication(@Param("userName") String userName);

    /**
     * @Author ldy
     * @Description 添加用户信息
     * @Date 2020/11/25 12:01
     * @Param sysUserEntity
     **/
    @SelectProvider(method = "addSysUser", type = SysUserProvider.class)
    void addSysUser(SysUserEntity sysUserEntity);

    /**
     * @Author ldy
     * @Description 根据账号删除用户信息
     * @Date 2020/11/25 17:55
     **/
    @Update("update sys_user set del_flag = 1 where uuid = #{uuid} and del_flag = 0")
    void delSysUser(@Param("uuid") Integer uuid);

    /**
     * @Author ldy
     * @Description 获取用户信息列表
     * @Date 2020/11/25 17:56
     **/
    @SelectProvider(method = "getUserList", type = SysUserProvider.class)
    List<SysUserEntity> getUserList(Map<String, Object> param);

    /****
     *  查询登录身份+路由
     */
    /*@Select("SELECT\n" +
            "\tGROUP_CONCAT( route ) 'route',\n" +
            "\tnick_name,\n" +
            "\trole_id,\n" +
            "\trole_name,\n" +
            "\tmenu_perm,\n" +
            "\tuuid\n" +
            "FROM\n" +
            "\t(\n" +
            "\tSELECT\n" +
            "\t  s1.uuid uuid,\n" +
            "\t\ts1.nick_name nick_name,\n" +
            "\t\ts1.role_id role_id,\n" +
            "\t\ts1.role_name role_name,\n" +
            "\t\ts1.menu_perm menu_perm,\n" +
            "\t\tm.route route\n" +
            "\tFROM\n" +
            "\t\t(\n" +
            "\t\tSELECT\n" +
            "\t\t\tsu.uuid,\n" +
            "\t\t\tsu.nick_name,\n" +
            "\t\t\tsu.role_id,\n" +
            "\t\t\tr.role_name,\n" +
            "\t\t\tr.menu_perm \n" +
            "\t\tFROM\n" +
            "\t\t\tsys_user su\n" +
            "\t\t\tLEFT JOIN role r ON su.role_id = r.id \n" +
            "\t\tWHERE\n" +
            "\t\t\tsu.uuid = #{uuid}\n" +
            "\t\t) s1\n" +
            " LEFT JOIN menu m on s1.menu_perm = m.menu_role \n" +
            "\t) a")
    SysUserEntity queryAll(SysUserEntity sysUserEntity);*/
    /**
     * @Author ldy
     * @Description 根据用户名获取用户信息
     * @Date 2020/11/25 17:59
     **/
    @Select("select * from sys_user u where u.user_name = #{userName}")
    SysUserEntity getUserInfo(@Param("userName") String userName);

    @Select("select * from sys_user where uuid = #{uuid}")
    SysUserEntity queryUserInfoById(@Param("uuid") Integer uuid);

    @UpdateProvider(method = "updateUserInfo" , type = SysUserProvider.class )
    void updateUserInfo(SysUserEntity sysUserEntity);
}
