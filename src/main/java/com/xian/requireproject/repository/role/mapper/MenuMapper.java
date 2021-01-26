package com.xian.requireproject.repository.role.mapper;

import com.xian.requireproject.service.role.dao.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MenuMapper {


    //@Select("SELECT id,menu_name menuName,menu_remark menuRemark,pid,menu_role menuRole from menu where menu_role = #{auth} ORDER BY sort ASC")
    @Select("SELECT menu_id menuId, menu_title menuTitle, name name, path path, menu_pid menuPid, redirect redirect, component component, menu_icon menuIcon, menu_role menuRole FROM menus WHERE menu_role = #{auth}")
    List<Menu> getRoleList(String auth);

    @Select("SELECT r.menu_perm menuPerm from sys_user u LEFT JOIN role r ON r.id = u.role_id WHERE u.uuid = #{userId}")
    String getUserAuthCode(String userId);


}
