package hxc.manage.service;

import hxc.manage.model.Department;

import java.util.List;

/**
 * @author hxc
 * @version 1.0
 * @date 2019/12/27 14:25
 */
public interface DepartmentService {

    List<Department> getAllDeps();

    List<Department> getDepByPid(Long l);

    int addDep(Department department);

    int deleteDep(Long did);
}
