package hxc.manage.service;

import hxc.manage.model.UserDetail;

import java.util.List;
import java.util.Map;

/**
 * @author hxc
 * @version 1.0
 * @date 2020/1/19 16:38
 */
public interface UserService {

    boolean delByUserId(String ids);

    List<Map<String, Object>> getAllTreePeople(String name);

    List<Map<String, Object>> getAllTreePeople1(String name);

    List<UserDetail> getAllEmployees();

    List<UserDetail> getUserByPage(Map<String, Object> map);

    Integer getUserByCount(Map<String, Object> map);

    int addUser(List<UserDetail> emps);

    void editUser(UserDetail userDetail);

    List<UserDetail> searchInfo(Map<String, Object> map, UserDetail userDetail);
}
