package hxc.manage.service.impl;

import hxc.manage.common.UserUtils;
import hxc.manage.mapper.MenuMapper;
import hxc.manage.model.Menu;
import hxc.manage.model.MenuVo;
import hxc.manage.service.MenuService;
import hxc.manage.util.RedisUtil;
import hxc.manage.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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



    public List<MenuVo> getMenusByUserId() {
        List<MenuVo> menu;
        menu= (List<MenuVo>) redisUtil.get("menu");
        if (menu==null) {
            menu = menuMapper.getMenusByUserId(UserUtils.getCurrentUser().getId());
//            menu = menuMapper.getMenusByUserId((long) 13);
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

    public Map<String, Object> getAllMenus(){
        List<Map<String, Object>> list=menuMapper.getAllParent();
        List<Map<String, Object>> menus;
        for (Map<String, Object> listMap : list) {
            menus = menuMapper.getAllMenus(listMap.get("id").toString());
            for (Map<String, Object> m : menus) {
                formatMenu(m);
            }
            listMap.put("children",menus);
            formatMenu(listMap);
        }
//        List<Map<String, Object>> list=menuMapper.getAllMenus(map);
        Integer count = menuMapper.getMenuCount();

//        for (Map<String, Object> m :list) {
//
//        }
        Map<String, Object> res = new HashMap<>();
        res.put("list",list);
        res.put("count",count);
        return res;
    }
    public void formatMenu(Map<String, Object> m){
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
    public void upMenu(Map<String, Object> menu) {
        menuMapper.upMenu(menu);
    }















}
