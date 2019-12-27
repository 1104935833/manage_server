package hxc.manage.service;

import hxc.manage.model.Salary;

import java.util.List;

/**
 * @author hxc
 * @version 1.0
 * @date 2019/12/27 14:30
 */
public interface SalaryService {

    int addSalary(Salary salary);

    List<Salary> getAllSalary();

    int updateSalary(Salary salary);

    int deleteSalary(String ids);

    int updateEmpSalary(Integer sid, Long eid);
}
