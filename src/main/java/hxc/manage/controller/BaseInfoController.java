package hxc.manage.controller;

import hxc.manage.common.DateConverter;
import hxc.manage.model.Performance;
import hxc.manage.model.RespBean;
import hxc.manage.model.User;
import hxc.manage.model.UserDetail;
import hxc.manage.service.BaseInfoService;
import hxc.manage.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/base")
public class BaseInfoController {

    @Autowired
    BaseInfoService baseInfoService;

    @Autowired
    UserServiceImpl userServiceImpl;

    @GetMapping("/userInfo")
    public Map<String,Object> userInfo(HttpServletRequest request){
        User u = (User) request.getSession().getAttribute("userinfo");
        UserDetail details=baseInfoService.userInfo(u.getId());
        Map<String,Object> map = new HashMap<>();
        map.put("details",details);
        map.put("office",baseInfoService.getOffices());
        return map;

    }

    @PostMapping("/changeInfo")
    public RespBean changeInfo(@RequestBody Map info, HttpServletRequest request){
        try {
            User  user = new User();
            Map<String, String> map = (Map<String, String>) info.get("info");
            User u = (User) request.getSession().getAttribute("userinfo");
            map.put("id", u.getId() + "");
            int i = baseInfoService.changeInfo(map);
            if(i>0){
                user= (User) userServiceImpl.loadUserByUsername(u.getWorkID());
            }

            return RespBean.ok("修改成功",user);
        }catch (Exception e){
            e.printStackTrace();
            return RespBean.error("修改失败");
        }
    }





}
