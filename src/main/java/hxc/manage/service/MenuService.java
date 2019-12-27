package hxc.manage.service;

import hxc.manage.model.Menu;

import java.util.List;

/**
 * @author hxc
 * @version 1.0
 * @date 2019/12/27 14:27
 */
public interface MenuService {
    List<Menu> menuTree();

    List<Long> getMenusByRid(Long rid);

    List<Menu> getMenusByHrId();

    List<Menu> getAllMenu();
}
