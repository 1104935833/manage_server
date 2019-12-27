package hxc.manage.service;

import hxc.manage.model.Role;

import java.util.List;

/**
 * @author hxc
 * @version 1.0
 * @date 2019/12/27 14:30
 */
public interface RoleService {
    int deleteRoleById(Long rid);

    int addNewRole(String role, String roleZh);

    List<Role> roles();
}
