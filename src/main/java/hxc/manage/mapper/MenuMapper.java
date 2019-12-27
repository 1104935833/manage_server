package hxc.manage.mapper;

import hxc.manage.model.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by sang on 2017/12/28.
 */
@Mapper
public interface MenuMapper {
    List<Menu> getAllMenu();

    List<Menu> getMenusByUserId(Long hrId);

    List<Menu> menuTree();

    List<Long> getMenusByRid(Long rid);
}
