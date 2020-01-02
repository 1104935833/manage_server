package hxc.manage.service.impl;

import hxc.manage.mapper.MenuMapper;
import hxc.manage.service.MenuService;
import hxc.manage.model.Menu;
import hxc.manage.common.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    MenuMapper menuMapper;

//    @Cacheable(key = "#root.methodName")
    public List<Menu> getAllMenu(){
        return menuMapper.getAllMenu();
    }

    @Override
    public List<Map<String, Object>> getAllTreePeople(String name) {
        List<Map<String,Object>> list;
        list= menuMapper.getAllTreePeople(name);
        for (Map<String, Object> map : list) {
            map.remove("parent_id");
            map.remove("id");
            map.remove("tree_code");
            map.remove("state");
        }
        return list;
    }

    @Override
    public List<Map<String, Object>> getAllTreePeople1(String name) {
        List<Map<String,Object>> list;
        list= menuMapper.getAllTreePeople1(name);

        return list;
    }

    public List<Menu> getMenusByUserId() {
        return menuMapper.getMenusByUserId(UserUtils.getCurrentUser().getId());
    }

    public List<Menu> menuTree() {
        return menuMapper.menuTree();
    }

    public List<Long> getMenusByRid(Long rid) {
        return menuMapper.getMenusByRid(rid);
    }
}
