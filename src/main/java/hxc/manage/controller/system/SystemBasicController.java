package hxc.manage.controller.system;

import com.alibaba.druid.util.StringUtils;
import hxc.manage.model.Menu;
import hxc.manage.model.RespBean;
import hxc.manage.model.Role;
import hxc.manage.service.*;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by sang on 2017/12/29.
 */
@RestController
@RequestMapping("/system/role")
public class SystemBasicController {
    
    @Autowired
    RoleService roleService;
    
    @Autowired
    MenuService menuService;
    
    @Autowired
    MenuRoleService menuRoleService;
    
    @Autowired
    DepartmentService departmentService;
    
    @Autowired
    PositionService positionService;
    
    @Autowired
    JobLevelService jobLevelService;
//
//    @RequestMapping(value = "/role/{rid}", method = RequestMethod.DELETE)
//    public RespBean deleteRole(@PathVariable Long rid) {
//        if (roleService.deleteRoleById(rid) == 1) {
//            return RespBean.ok("删除成功!");
//        }
//        return RespBean.error("删除失败!");
//    }
//
//    @RequestMapping(value = "/addRole", method = RequestMethod.POST)
//    public RespBean addNewRole(String role, String roleZh) {
//        if (roleService.addNewRole(role, roleZh) == 1) {
//            return RespBean.ok("添加成功!");
//        }
//        return RespBean.error("添加失败!");
//    }
//
//    @RequestMapping(value = "/menuTree/{rid}", method = RequestMethod.GET)
//    public Map<String, Object> menuTree(@PathVariable Long rid) {
//        Map<String, Object> map = new HashMap<>();
//        List<Menu> menus = menuService.menuTree();
//        map.put("menus", menus);
//        List<Long> selMids = menuService.getMenusByRid(rid);
//        map.put("mids", selMids);
//        return map;
//    }
//
//    @RequestMapping(value = "/updateMenuRole", method = RequestMethod.PUT)
//    public RespBean updateMenuRole(Long rid, Long[] mids) {
//        if (menuRoleService.updateMenuRole(rid, mids) == mids.length) {
//            return RespBean.ok("更新成功!");
//        }
//        return RespBean.error("更新失败!");
//    }

//    @RequestMapping("/roles")
//    public List<Role> allRoles() {
//        return roleService.roles();
//    }

//    @RequestMapping(value = "/dep", method = RequestMethod.POST)
//    public Map<String, Object> addDep(Department department) {
//        Map<String, Object> map = new HashMap<>();
//        if (departmentService.addDep(department) == 1) {
//            map.put("status", "success");
//            map.put("msg", department);
//            return map;
//        }
//        map.put("status", "error");
//        map.put("msg", "添加失败!");
//        return map;
//    }

//    @RequestMapping(value = "/dep/{did}", method = RequestMethod.DELETE)
//    public RespBean deleteDep(@PathVariable Long did) {
//        if (departmentService.deleteDep(did) == 1) {
//            return RespBean.ok("删除成功!");
//        }
//        return RespBean.error("删除失败!");
//    }
//
//    @RequestMapping(value = "/dep/{pid}", method = RequestMethod.GET)
//    public List<Department> getDepByPid(@PathVariable Long pid) {
//        return departmentService.getDepByPid(pid);
//    }
//
//    @RequestMapping(value = "/deps", method = RequestMethod.GET)
//    public List<Department> getAllDeps() {
//        return departmentService.getAllDeps();
//    }
//
//    @RequestMapping(value = "/position", method = RequestMethod.POST)
//    public RespBean addPos(Position pos) {
//        int result = positionService.addPos(pos);
//        if (result == 1) {
//            return RespBean.ok("添加成功!");
//        } else if (result == -1) {
//            return RespBean.error("职位名重复，添加失败!");
//        }
//        return RespBean.error("添加失败!");
//    }
//
//    @RequestMapping(value = "/positions", method = RequestMethod.GET)
//    public List<Position> getAllPos() {
//        return positionService.getAllPos();
//    }
//
//    @RequestMapping("/position/{pids}")
//    public RespBean deletePosById(@PathVariable String pids) {
//        if (positionService.deletePosById(pids)) {
//            return RespBean.ok("删除成功!");
//        }
//        return RespBean.error("删除失败!");
//    }

//    @RequestMapping(value = "/position", method = RequestMethod.PUT)
//    public RespBean updatePosById(Position position) {
//        if (positionService.updatePosById(position) == 1) {
//            return RespBean.ok("修改成功!");
//        }
//        return RespBean.error("修改失败!");
//    }
//
//    @RequestMapping(value = "/joblevel", method = RequestMethod.POST)
//    public RespBean addJobLevel(JobLevel jobLevel) {
//        int result = jobLevelService.addJobLevel(jobLevel);
//        if (result == 1) {
//            return RespBean.ok("添加成功!");
//        } else if (result == -1) {
//            return RespBean.error("职称名重复，添加失败!");
//        }
//        return RespBean.error("添加失败!");
//    }
    //删除菜单
    @GetMapping("/menudel")
    public RespBean menuDelById(@RequestParam("id") String id){
        try {
            menuService.menuDelById(id);
            return RespBean.ok("删除成功");
        }catch (Exception e){
            e.printStackTrace();
        }
        return RespBean.ok("删除失败");
    }
    //禁用菜单
    @GetMapping("/menuhide")
    public RespBean menuHide(@RequestParam("id") String id,@RequestParam("type") String enabled){
        try {
            menuService.menuHideById(id,enabled);
            return RespBean.ok("操作成功");
        }catch (Exception e){
            e.printStackTrace();
        }
        return RespBean.ok("操作失败");

    }

//    获取用户管理左侧树节点
    @GetMapping(value = "/treepeople")
    public List<Map<String, Object>> getAllTreePeople(@RequestParam("name") String name) {
        List<Map<String, Object>> list;
        int tmp = name.indexOf("教研室");
        if(tmp==-1){
            list= menuService.getAllTreePeople(name);
        }else {
            list= menuService.getAllTreePeople1(name);
        }
        return list;
    }
//    菜单管理获取全部菜单
    @GetMapping("/getAllMenus")
    public Map<String,Object>  getAllMenu(@RequestParam(defaultValue = "1") Integer page,
                               @RequestParam(defaultValue = "10") Integer size){
        int start = (page - 1) * size;
        Map<String, Object> map = new HashMap<>();
        map.put("size",size);
        map.put("start",start);
        Map<String,Object> list=menuService.getAllMenus(map);

        return list;

    }
//    @RequestMapping(value = "/joblevel/{ids}", method = RequestMethod.DELETE)
//    public RespBean deleteJobLevelById(@PathVariable String ids) {
//        if (jobLevelService.deleteJobLevelById(ids)) {
//            return RespBean.ok("删除成功!");
//        }
//        return RespBean.error("删除失败!");
//    }
//
//    @RequestMapping(value = "/joblevel", method = RequestMethod.PUT)
//    public RespBean updateJobLevel(JobLevel jobLevel) {
//        if (jobLevelService.updateJobLevel(jobLevel) == 1) {
//            return RespBean.ok("修改成功!");
//        }
//        return RespBean.error("修改失败!");
//    }
}
