package hxc.manage.controller.emp;

import hxc.manage.model.UserDetails;
import hxc.manage.service.*;
import hxc.manage.model.RespBean;
import hxc.manage.common.poi.PoiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
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

    @GetMapping("/delByUserId")
    public RespBean delByUserId(@RequestParam("id") String id){
        if(empService.delByUserId(id)){
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");

    }

    //    获取用户管理左侧树节点
    @GetMapping(value = "/treepeople")
    public List<Map<String, Object>> getAllTreePeople(@RequestParam("name") String name) {
        List<Map<String, Object>> list;
        int tmp = name.indexOf("教研室");
        if(tmp==-1){
            list= empService.getAllTreePeople(name);
        }else {
            list= empService.getAllTreePeople1(name);
        }
        return list;
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

    @PostMapping("/searchinfo")
    public Map<String, Object> searchInfo(UserDetails userDetails){
        int start = (userDetails.getPage() - 1) * 10;
        Map<String, Object> map = new HashMap<>();
        map.put("size",10);
        map.put("start",start);

        List<UserDetails> userDetailsByPage =empService.searchInfo(map,userDetails);
        map.put("count",empService.getUserByCount(convertBeanToMap(userDetails)));
        map.put("users", userDetailsByPage);
        return map;
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
        List<UserDetails> emps = PoiUtils.importEmp2List(file);

        if (empService.addUser(emps) == emps.size()) {
            return RespBean.ok("导入成功!");
        }
        return RespBean.error("导入失败!");
    }

    @PostMapping("/adduser")
    public RespBean addUser(UserDetails userDetails){
        try {
            List<UserDetails> emps =new ArrayList<>();
            emps.add(userDetails);
            empService.addUser(emps);
            return RespBean.ok("添加成功！");
        }catch(Exception e){
            e.printStackTrace();
        }
        return RespBean.ok("添加失败！");
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
    /**
          * 实体类转map
          * @param obj
          * @return
          */
      public static Map<String, Object> convertBeanToMap(Object obj) {
          if (obj == null) {
              return null;
          }
          Map<String, Object> map = new HashMap<String, Object>();
          try {
              BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
              PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
              for (PropertyDescriptor property : propertyDescriptors) {
                  String key = property.getName();
                  // 过滤class属性
                  if (!key.equals("class")) {
                      // 得到property对应的getter方法
                      Method getter = property.getReadMethod();
                      Object value = getter.invoke(obj);
                      if(null==value){
                          map.put(key,"");
                      }else{
                          map.put(key,value);
                      }
                  }
              }
          } catch (Exception e) {

          }
          return map;
      }

}

