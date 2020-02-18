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
    List<Menu> getMenusByUserId();

    List<Menu> getAllMenu();

    Map<String, Object> getAllMenus();

    void menuDelById(String id);

    void menuHideById(String id,String enabled);

    List<Map<String, Object>> getAllParent();

    void addMenu(Menu menu);

    void upMenu(Map<String, Object> menu);














}
