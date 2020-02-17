package hxc.manage.mapper;

import hxc.manage.model.Office;
import hxc.manage.model.User;
import hxc.manage.model.UserDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import hxc.manage.model.Role;
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
public interface UserMapper {

    User loadUserByUsername(String username);

    List<Role> getRolesByUserId(Long id);

//    int userReg(@Param("username") String username, @Param("password") String password);
//
//    List<User> getUsersByKeywords(@Param("keywords") String keywords);
//
//    int updateUser(User user);
//
//    int deleteRoleByUserId(Long userId);
//
//    int addRolesForUser(@Param("userId") Long userId, @Param("rids") Long[] rids);
//
//    User getUserById(Long userId);
//
//    int deleteUser(Long userId);

    List<User> getAllUser(@Param("currentId") Long currentId);

    List<UserDetail> getEmployeeByPage();

    List<Map<String, Object>> getAllTreePeople(@Param("name") String name);

    List<Map<String, Object>> getAllTreePeople1(@Param("name") String name);

    int delByUserId(@Param("ids") String[] ids);

    int delDetailByUserId(@Param("ids") String[] ids);

    int delRoleByUserId(@Param("ids") String[] ids);

    int addEmps(@Param("emps") List<UserDetail> emps);

    List<UserDetail> getUserByPage(Map<String, Object> map);

    Integer getUserByCount(Map<String, Object> map);

    Integer getLastUserWorkId();

    Integer addUser(UserDetail userDetail);

    void editUser(UserDetail userDetail);

    void editUserDetails(UserDetail userDetail);

    List<UserDetail> searchInfo(@Param("map")Map<String, Object> map, @Param("emp") UserDetail userDetail);

    List<Office> getAllOffice();

}
