package hxc.manage.service;

import hxc.manage.model.Menu;

import java.util.List;
import java.util.Map;

/**
 * @author hxc
 * @version 1.0
 * @date 2019/12/27 14:27
 */
public interface MenuService {
    List<Menu> menuTree();

    List<Long> getMenusByRid(Long rid);

    List<Menu> getMenusByUserId();

    List<Menu> getAllMenu();

    List<Map<String, Object>> getAllTreePeople(String name);

    List<Map<String, Object>> getAllTreePeople1(String name);

    Map<String, Object> getAllMenus(Map<String, Object> map);


    void menuDelById(String id);

    void menuHideById(String id,String enabled);

    List<Map<String, Object>> getAllParent();

    void addMenu(Menu menu);
}
