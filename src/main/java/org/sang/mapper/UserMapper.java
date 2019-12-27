package org.sang.mapper;

import org.apache.ibatis.annotations.Param;
import org.sang.model.User;
import org.sang.model.Role;

import java.util.List;

/**
 * Created by sang on 2017/12/28.
 */
public interface UserMapper {
    User loadUserByUsername(String username);

    List<Role> getRolesByUserId(Long id);

    int userReg(@Param("username") String username, @Param("password") String password);

    List<User> getUsersByKeywords(@Param("keywords") String keywords);

    int updateUser(User user);

    int deleteRoleByUserId(Long userId);

    int addRolesForUser(@Param("userId") Long userId, @Param("rids") Long[] rids);

    User getUserById(Long userId);

    int deleteUser(Long userId);

    List<User> getAllUser(@Param("currentId") Long currentId);
}
