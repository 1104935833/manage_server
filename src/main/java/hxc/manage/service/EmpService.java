package hxc.manage.service;

import hxc.manage.model.Employee;
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

    int updateEmp(Employee employee);

    boolean deleteEmpById(String ids);



    List<Employee> getAllEmployees();

    int addEmps(List<Employee> emps);

    List<Employee> getEmployeeByPageShort(Integer page, Integer size);

    List<Employee> getUserByPage(Map<String, Object> map);

    Integer getUserByCount(Map<String, Object> map);
}
