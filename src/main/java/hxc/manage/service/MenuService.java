package hxc.manage.service;

import hxc.manage.model.Menu;
import hxc.manage.model.Part;
import hxc.manage.model.Role;

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

    Map<String, Object> getAllMenus(Map<String, Object> map);

    void menuDelById(String id);

    void menuHideById(String id,String enabled);

    List<Map<String, Object>> getAllParent();

    void addMenu(Menu menu);

    void upMenu(Menu menu);

    List<Role> getAllRole();

    Map<String, Object> getPartMenuById(String id);

    void delPart(String id,Integer state);

    void editPart(Map map);

    Map<String,List> getTrandferUser(String rid);

}
