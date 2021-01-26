package com.xian.requireproject.service.role.impl;


import com.xian.requireproject.repository.role.mapper.MenuMapper;
import com.xian.requireproject.service.role.MenuService;
import com.xian.requireproject.service.role.dao.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ldy
 * @Descriptions 管理员用户接口实现类
 * @Date 2020/11/25 11:13
 * @Version: V1.0
 **/
@Service
public class MenuServiceImpl implements MenuService {

    private static final String KEY_PATH_HOME_ROUTE = "home/index";

    @Autowired
    private MenuMapper menuMapper;


    public List<Menu> menuList(List<Menu> menu) {
        List<Menu> list = new ArrayList<>();
        menu.forEach(x ->{
            if (x.getMenuPid().equals("0")) {
                //x.setComponent("Layout");
                x.setChildren(menuChild(x.getMenuId(),menu));
                list.add(x);
            }
        });
        return list;
    }

    public List<Menu> menuChild(String id,List<Menu> menu) {
        List<Menu> lists = new ArrayList<>();
        menu.forEach(a ->{
            if (a.getMenuPid().equals(id)) {
                if (KEY_PATH_HOME_ROUTE.equals(a.getComponent())) {
                    a.setHidden("true");
                }
                a.setChildren(menuChild(a.getMenuId(),menu));
                lists.add(a);
            }
        });
        return lists;
    }

    @Override
    public List<Menu> getMenuList(String userId) {
        List<Menu> menuList = menuMapper.getRoleList(menuMapper.getUserAuthCode(userId));
        return menuList(menuList);
    }



}
