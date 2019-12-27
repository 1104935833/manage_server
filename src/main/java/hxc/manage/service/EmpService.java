package hxc.manage.service;

import hxc.manage.model.Employee;
import hxc.manage.model.Nation;
import hxc.manage.model.PoliticsStatus;

import java.util.List;

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

    List<Employee> getEmployeeByPage(Integer page, Integer size, String keywords, Long politicId, Long nationId, Long posId, Long jobLevelId, String engageForm, Long departmentId, String beginDateScope);

    Long getCountByKeywords(String keywords, Long politicId, Long nationId, Long posId, Long jobLevelId, String engageForm, Long departmentId, String beginDateScope);

    List<Employee> getAllEmployees();

    int addEmps(List<Employee> emps);

    List<Employee> getEmployeeByPageShort(Integer page, Integer size);
}
