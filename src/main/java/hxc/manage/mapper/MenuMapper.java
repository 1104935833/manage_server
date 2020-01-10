package hxc.manage.mapper;

import hxc.manage.model.Menu;
import hxc.manage.model.Part;
import hxc.manage.model.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author hxc
 * @version 1.0
 * @date 2019/12/27 14:26
 */
@Mapper
@Component
public interface MenuMapper {
    List<Menu> getAllMenu();

    List<Menu> getMenusByUserId(Long hrId);

    List<Menu> menuTree();

    List<Long> getMenusByRid(Long rid);

    List<Map<String, Object>> getAllMenus(Map<String, Object> map);

    Integer getMenuCount();

    void menuDelById(@Param("id") String id);

    void menuHideById(@Param("id") String id,@Param("enabled") String enabled);

    List<Map<String, Object>> getAllParent();

    void addMenu(Menu menu);

    void upMenu(Menu menu);

    List<Role> getAllRole();

    List<Part> getPartMenu(@Param("id") String id);

    List<Map<String, Object>> getPartMenuSon(@Param("id") String id);

}
