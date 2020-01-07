package hxc.manage.service;

import hxc.manage.model.UserDetails;
import hxc.manage.model.Nation;
import hxc.manage.model.PoliticsStatus;

import java.util.List;
import java.util.Map;

/**
 * @author hxc
 * @version 1.0
 * @date 2019/12/27 14:26
 */
public interface EmpService {
    List<Nation> getAllNations();

    List<PoliticsStatus> getAllPolitics();

    Long getMaxWorkID();

    int updateEmp(UserDetails userDetails);

    boolean delByUserId(String ids);



    List<UserDetails> getAllEmployees();

    int addEmps(List<UserDetails> emps);

    List<UserDetails> getEmployeeByPageShort(Integer page, Integer size);

    List<UserDetails> getUserByPage(Map<String, Object> map);

    Integer getUserByCount(Map<String, Object> map);


    void addUser(UserDetails userDetails);

    void editUser(UserDetails userDetails);
}
