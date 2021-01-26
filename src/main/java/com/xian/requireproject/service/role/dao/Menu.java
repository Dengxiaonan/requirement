package com.xian.requireproject.service.role.dao;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Description: 菜单实体
 */
@Data
public class Menu {

    /**
     * 菜单id
     */
    private String menuId;

    /**
     * 菜单名称
     */
    private String menuTitle;

    /**
     * 菜单页面缓存
     */
    private String menuName;


    /**
     * url地址
     */
    private String path;

    /**
     * 父级id
     */
    private String menuPid;

    /**
     * 路由
     */
    private String menuRoute;
    /**
     * 重定向地址
     */
    private String component;
    /**
     * 图标类型
     */
    private String menuIcon;
    /**
     * 菜单的角色
     */
    private String menuRole;
    /**
     * 首页进行其他菜单隐藏
     */
    private String hidden;

    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private List<Menu> children;

}
