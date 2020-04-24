package hxc.manage.mapper;

import hxc.manage.model.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author hxc
 * @version 1.0
 * @date 2019/12/27 14:26
 */
@Mapper
public interface RoleMapper {
    List<Role> roles();

    int addNewRole(@Param("role") String role, @Param("roleZh") String roleZh);

    int deleteRoleById(Long rid);

    int getUserRole(String userId);
}
