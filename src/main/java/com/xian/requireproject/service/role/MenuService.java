package com.xian.requireproject.service.role;

import com.xian.requireproject.service.role.dao.Menu;

import java.util.List;

/**
 *
 * 用户信息接口类
 */


public interface MenuService {

    List<Menu> getMenuList(String userId);
}
