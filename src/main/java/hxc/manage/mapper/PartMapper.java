package hxc.manage.mapper;

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
 * @date 2020/1/19 16:59
 */
@Mapper
@Component
public interface PartMapper {

    void addPart(@Param("name") String name, @Param("nameZh") String nameZh);

    List<Map<String,Object>> getTrandferUser(@Param("rid") String rid,@Param("direct") String direct);

    void delPartUserById(@Param("partId") Integer partId, @Param("type") String type);

    void editPartUser(@Param("parts") List parts, @Param("partId") Integer partId, @Param("type") String type);

    void updateRoleById(Map<String, Object> map);

    void insertMenuRole(Map<String, Object> map);

    void delMenuRole(Integer id);

    List<Part> getPartMenuById(@Param("id") String id);

    List<Map<String, Object>> getPartMenuSon(@Param("id") String id,@Param("tableName") String state);

    List<Role> getAllRole();


    List<Map<String, Object>> getTrandferManagUser(@Param("rid") String rid);
}
