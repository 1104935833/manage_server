package hxc.manage.controller.salary;

import hxc.manage.service.SalaryService;
import hxc.manage.model.RespBean;
import hxc.manage.model.Salary;
import hxc.manage.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author hxc
 * @version 1.0
 * @date 2019/12/27 14:26
 */
@RestController
@RequestMapping("/salary/sobcfg")
public class SalaryEmpController {

    @Autowired
    SalaryService salaryService;

    @Autowired
    EmpService empService;

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public RespBean updateEmpSalary(Integer sid, Long eid) {
        if (salaryService.updateEmpSalary(sid, eid) == 1) {
            return RespBean.ok("修改成功!");
        }
        return RespBean.error("修改失败!");
    }

    @RequestMapping(value = "/salaries", method = RequestMethod.GET)
    public List<Salary> salaries() {
        return salaryService.getAllSalary();
    }
//
//    @RequestMapping(value = "/emp", method = RequestMethod.GET)
//    public Map<String, Object> getEmployeeByPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size) {
//        Map<String, Object> map = new HashMap<>();
//        List<UserDetails> employeeByPage = empService.getEmployeeByPageShort(page, size);
//        Long count = empService.getCountByKeywords("", null, null, null, null, null, null, null);
//        map.put("emps", employeeByPage);
//        map.put("count", count);
//        return map;
//    }
}
