package hxc.manage.controller.system;

import hxc.manage.common.poi.PoiUtils;
import hxc.manage.model.*;
import hxc.manage.service.*;
import hxc.manage.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

/**
 * Created by sang on 2017/12/29.
 */
@RestController
@RequestMapping("/system/user")
public class SystemUserController {

    @Autowired
    Util util;

    @Autowired
    UserService userService;

    @GetMapping("/delByUserId")
    public RespBean delByUserId(@RequestParam("id") String id) {
        if (userService.delByUserId(id)) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");

    }

    //    获取用户管理左侧树节点
    @GetMapping("/treepeople")
    public RespBean getAllTreePeople(@RequestParam("name") String name) {
        List<Map<String, Object>> list;
        int tmp = name.indexOf("教研室");
        if (tmp == -1) {
            list = userService.getAllTreePeople(name);
        } else {
            list = userService.getAllTreePeople1(name);
        }
        return RespBean.ok("success", list);

    }

    //所有办公室
    @GetMapping(value = "/office")
    public RespBean getAllOffice() {
        List<Office> offices = userService.getAllOffice();

        return RespBean.ok("success", offices);

    }

    @GetMapping("/count")
    public RespBean getUserByCount(@RequestParam(defaultValue = "") String keywords) {
        Map<String, Object> map = new HashMap<>();
        map.put("keywords", keywords);
        keyVaildata(keywords, map);
        Integer count = userService.getUserByCount(map);
        map.put("count", count);
        return RespBean.ok("success", map);
    }

    @RequestMapping("/getUserByPage")
    public RespBean getUserByPage(@RequestParam(defaultValue = "1") Integer page,
                                  @RequestParam(defaultValue = "10") Integer size,
                                  @RequestParam(defaultValue = "") String keywords) {
        int start = (page - 1) * size;
        Map<String, Object> map = new HashMap<>();
        map.put("size", size);
        map.put("start", start);
        map.put("keywords", keywords);
        keyVaildata(keywords, map);
        List<UserDetail> userDetailByPage = userService.getUserByPage(map);
        map.put("users", userDetailByPage);
        return RespBean.ok("success", map);

    }

    @PostMapping("/searchinfo")
    public RespBean searchInfo(UserDetail userDetail) {
        int start = (userDetail.getPage() - 1) * 10;
        Map<String, Object> map = new HashMap<>();
        map.put("size", 10);
        map.put("start", start);

        List<UserDetail> userDetailByPage = userService.searchInfo(map, userDetail);
        map.put("count", userService.getUserByCount(util.convertBeanToMap(userDetail)));
        map.put("users", userDetailByPage);
        return RespBean.ok("success", map);

    }


    @PostMapping("/edituser")
    public RespBean edituser(UserDetail userDetail, BindingResult bindingResult) {
        try {
            userService.editUser(userDetail);
            return RespBean.ok("添加成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return RespBean.ok("添加失败！");
    }

    @RequestMapping(value = "/exportEmp", method = RequestMethod.GET)
    public ResponseEntity<byte[]> exportEmp() {
        return PoiUtils.exportEmp2Excel(userService.getAllEmployees());
    }

    @RequestMapping(value = "/importEmp", method = RequestMethod.POST)
    public RespBean importEmp(MultipartFile file) {
        List<UserDetail> emps = PoiUtils.importEmp2List(file);

        if (userService.addUser(emps) == emps.size()) {
            return RespBean.ok("导入成功!");
        }
        return RespBean.error("导入失败!");
    }

    @PostMapping("/adduser")
    public RespBean addUser(UserDetail userDetail) {
        try {
            List<UserDetail> emps = new ArrayList<>();
            emps.add(userDetail);
            userService.addUser(emps);
            return RespBean.ok("添加成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return RespBean.ok("添加失败！");
    }

    private RespBean keyVaildata(String keywords, Map<String, Object> map) {
        if (keywords.indexOf("教研室") > -1) {
            map.put("rank", 2);
        } else if (keywords.indexOf("分院") > -1) {
            map.put("rank", 1);
        } else if (!keywords.equals("")) {
            map.put("rank", 3);
        }
        return RespBean.ok("success", map);

    }

}
