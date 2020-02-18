package hxc.manage.mapper;

import hxc.manage.model.Menu;
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

    List<Map<String, Object>> getAllMenus(@Param("id") String id);

    Integer getMenuCount();

    void menuDelById(@Param("id") String id);

    void menuHideById(@Param("id") String id,@Param("enable") String enabled);

    List<Map<String, Object>> getAllParent();

    void addMenu(Menu menu);

    void upMenu(Menu menu);

}
