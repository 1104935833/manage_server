package hxc.manage.service.impl;

import com.alibaba.druid.util.StringUtils;
import hxc.manage.mapper.MenuMapper;
import hxc.manage.model.Part;
import hxc.manage.model.Role;
import hxc.manage.service.MenuService;
import hxc.manage.model.Menu;
import hxc.manage.common.UserUtils;
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
    MenuMapper menuMapper;

//    @Cacheable(key = "#root.methodName")
    public List<Menu> getAllMenu(){
        return menuMapper.getAllMenu();
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

    @Override
    public List<Role> getAllRole() {

        return menuMapper.getAllRole();
    }

    @Override
    public Map<String, Object> getPartMenuById(String id) {
        Map<String, Object> res = new HashMap<>();
        List<Part> list = menuMapper.getPartMenuById(id);
        List<Map<String, Object>> map;
        if(StringUtils.equals(id,"")) {

            for (Part pa : list) {
                map = menuMapper.getPartMenuSon(pa.getId() + "","0");
                pa.setChildren(map);
            }
            res.put("part", list);
        }
        else {
            List<Map<String, Object>> tmp = new ArrayList();
            for (Part pa : list) {
                Map<String, Object> t1 = new HashMap<>();
                t1.put("id",pa.getId());
                tmp.add(t1);
                map = menuMapper.getPartMenuSon(pa.getId() + "","1");
                for (Map<String, Object> pas : map) {
                    Map<String, Object> t2 = new HashMap<>();
                    t2.put("id",pas.get("id"));
                    tmp.add(t2);
                }
            }
            res.put("part", tmp);



        }
        return res;
    }

    @Override
    public void delPart(String id,Integer state) {
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("state",state);
        menuMapper.updateRoleById(map);
    }

    @Override
    public void editPart(Map map) {
        Map form = (Map) map.get("form");
        menuMapper.updateRoleById(form);
        Integer id = (Integer) form.get("id");
        menuMapper.delMenuRole(id);
        List list = (List) map.get("nodes");
        if (list.size()>0) {
            Map<String, Object> nodes = new HashMap<>();
            nodes.put("list", list);
            nodes.put("id", id);
            menuMapper.insertMenuRole(nodes);
        }
    }

    @Override
    public Map<String,List> getTrandferUser(String rid) {
        List<Map<String,Object>> leftmap = menuMapper.getTrandferUser(rid,"left");
        List<Map<String,Object>> rightmap = menuMapper.getTrandferUser(rid,"right");
        List leftLabel = new ArrayList();
        List leftValue = new ArrayList();
        List rightLabel = new ArrayList();
        List rightValue = new ArrayList();
        for (Map<String, Object> map:leftmap){
            leftLabel.add(map.get("name"));
            leftValue.add(map.get("id"));
        }
        for (Map<String, Object> map:rightmap) {
            rightLabel.add(map.get("name"));
            rightValue.add(map.get("id"));
        }
        Map<String,List> map = new HashMap<>();
        map.put("leftLabel",leftLabel);
        map.put("leftValue",leftValue);
        map.put("rightLabel",rightLabel);
        map.put("rightValue",rightValue);
        return map;
    }


}
