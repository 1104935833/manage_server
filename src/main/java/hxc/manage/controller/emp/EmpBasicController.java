package hxc.manage.controller.emp;

import hxc.manage.model.UserDetails;
import hxc.manage.service.JobLevelService;
import hxc.manage.service.PositionService;
import hxc.manage.model.RespBean;
import hxc.manage.common.poi.PoiUtils;
import hxc.manage.service.DepartmentService;
import hxc.manage.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hxc
 * @version 1.0
 * @date 2019/12/27 14:26
 */
@RestController
@RequestMapping("/employee/basic")
public class EmpBasicController {

    @Autowired
    EmpService empService;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    PositionService positionService;

    @Autowired
    JobLevelService jobLevelService;



    @GetMapping("/delByUserId")
    public RespBean delByUserId(@RequestParam("id") String id){
        if(empService.delByUserId(id)){
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");

    }


    @GetMapping("/count")
    public Map<String, Object> getUserByCount(@RequestParam(defaultValue = "") String keywords){
        Map<String, Object> map = new HashMap<>();
        map.put("keywords",keywords);
        keyVaildata(keywords,map);
        Integer count =empService.getUserByCount(map);
        map.put("count",count);
        return map;
    }


    @RequestMapping("/getUserByPage")
    public Map<String, Object> getUserByPage(@RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "") String keywords){
        int start = (page - 1) * size;
        Map<String, Object> map = new HashMap<>();
        map.put("size",size);
        map.put("start",start);
        map.put("keywords",keywords);
        keyVaildata(keywords,map);
        List<UserDetails> userDetailsByPage =empService.getUserByPage(map);
        map.put("users", userDetailsByPage);
        return map;
    }

    @PostMapping("/adduser")
    public RespBean addUser(UserDetails userDetails){
    try {
        empService.addUser(userDetails);
        return RespBean.ok("添加成功！");
    }catch(Exception e){
        e.printStackTrace();
    }
        return RespBean.ok("添加失败！");
    }

    @PostMapping("/edituser")
    public RespBean edituser(UserDetails userDetails, BindingResult bindingResult){
        try {
            System.out.println(userDetails);
            empService.editUser(userDetails);
            return RespBean.ok("添加成功！");
        }catch(Exception e){
            e.printStackTrace();
        }
        return RespBean.ok("添加失败！");
    }



    @RequestMapping(value = "/exportEmp", method = RequestMethod.GET)
    public ResponseEntity<byte[]> exportEmp() {
        return PoiUtils.exportEmp2Excel(empService.getAllEmployees());
    }

    @RequestMapping(value = "/importEmp", method = RequestMethod.POST)
    public RespBean importEmp(MultipartFile file) {
        List<UserDetails> emps = PoiUtils.importEmp2List(file,
                empService.getAllNations(), empService.getAllPolitics(),
                departmentService.getAllDeps(), positionService.getAllPos(),
                jobLevelService.getAllJobLevels());
        if (empService.addEmps(emps) == emps.size()) {
            return RespBean.ok("导入成功!");
        }
        return RespBean.error("导入失败!");
    }


    private Map<String,Object> keyVaildata(String keywords,Map<String,Object> map){
        if(keywords.indexOf("教研室")>-1){
            map.put("rank",2);
        }else if(keywords.indexOf("分院")>-1) {
            map.put("rank",1);
        }else if(!keywords.equals("")){
            map.put("rank",3);
        }
        return map;
    }
}

