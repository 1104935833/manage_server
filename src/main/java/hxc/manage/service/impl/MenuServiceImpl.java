package hxc.manage.service.impl;

import com.alibaba.druid.util.StringUtils;
import hxc.manage.mapper.MenuMapper;
import hxc.manage.model.Part;
import hxc.manage.model.Role;
import hxc.manage.service.MenuService;
import hxc.manage.model.Menu;
import hxc.manage.common.UserUtils;
import hxc.manage.util.RedisUtil;
import hxc.manage.util.Util;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hxc
 * @version 1.0
 * @date 2019/12/27 14:26
 */
@Service
@Transactional
@CacheConfig(cacheNames = "menus_cache")
public class MenuServiceImpl implements MenuService {

    @Autowired
    Util util;

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    MenuMapper menuMapper;

//    @Cacheable(key = "#root.methodName")
    public List<Menu> getAllMenu(){
        List<Menu> menuAll;
        menuAll = (List<Menu>) redisUtil.get("menuAll");//读取redis
        if(menuAll==null) {
            menuAll = menuMapper.getAllMenu();
            redisUtil.set("menuAll",menuAll);
        }

        return menuAll;
    }



    public List<Menu> getMenusByUserId() {
        List<Menu> menu;
        menu= (List<Menu>) redisUtil.get("menu");
        if (menu==null) {
            menu = menuMapper.getMenusByUserId(UserUtils.getCurrentUser().getId());
            redisUtil.set("menu",menu);
        }
        return menu;

    }

//    public List<Menu> menuTree() {
//        return menuMapper.menuTree();
//    }
//
//    public List<Long> getMenusByRid(Long rid) {
//        return menuMapper.getMenusByRid(rid);
//    }

    public Map<String, Object> getAllMenus(Map<String,Object> map){
        List<Map<String, Object>> list=menuMapper.getAllMenus(map);
        Integer count = menuMapper.getMenuCount();

        for (Map<String, Object> m :list) {
            if ((int)m.get("parentId")>1){
                m.put("parent","菜单");
            }else {
                m.put("parent","目录");
            }
            if ((boolean)m.get("enabled")) {
                m.put("type","有效");
            } else {
                m.put("type","无效");
            }
        }
        Map<String, Object> res = new HashMap<>();
        res.put("list",list);
        res.put("count",count);
        return res;
    }

    @Override
    public void menuDelById(String id) {
        menuMapper.menuDelById(id);
    }

    @Override
    public void menuHideById(String id,String enabled) {
        menuMapper.menuHideById(id,enabled);
    }

    @Override
    public List<Map<String, Object>> getAllParent() {

        return menuMapper.getAllParent();
    }

    @Override
    public void addMenu(Menu menu) {
        menuMapper.addMenu(menu);
    }

    @Override
    public void upMenu(Menu menu) {
        menuMapper.upMenu(menu);
    }















}
