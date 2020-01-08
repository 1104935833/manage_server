package hxc.manage.service;

import hxc.manage.model.UserDetails;
import hxc.manage.model.Nation;
import hxc.manage.model.PoliticsStatus;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author hxc
 * @version 1.0
 * @date 2019/12/27 14:26
 */
public interface EmpService {

    boolean delByUserId(String ids);

    List<Map<String, Object>> getAllTreePeople(String name);

    List<Map<String, Object>> getAllTreePeople1(String name);

    List<UserDetails> getAllEmployees();

    List<UserDetails> getUserByPage(Map<String, Object> map);

    Integer getUserByCount(Map<String, Object> map);

    int addUser(List<UserDetails> emps);

    void editUser(UserDetails userDetails);

    List<UserDetails> searchInfo( Map<String, Object> map, UserDetails userDetails);
}
