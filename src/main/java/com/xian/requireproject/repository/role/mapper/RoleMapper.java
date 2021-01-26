package com.xian.requireproject.repository.role.mapper;

import com.xian.requireproject.repository.role.provider.RoleProvider;
import com.xian.requireproject.service.role.dao.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.security.acl.Group;
import java.util.List;

@Mapper
public interface RoleMapper {


    @Select("SELECT id,role_name roleName,role_remark roleRemark,menu_perm menuPerm from role")
    List<Role> getRoleList();

    @SelectProvider(method = "addRole", type = RoleProvider.class)
    List<Group> addRole(Role role);

    @SelectProvider(method = "updateRole", type = RoleProvider.class)
    List<Group> updateRole(Role role);

    @Delete("DELETE FROM role WHERE id = #{id}")
    void deleteRole(String id);


}
