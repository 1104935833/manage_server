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

    @PostMapping("/serchPerformance")
    public Map<String,Object> serchPerformance(@RequestBody Map info, HttpServletRequest request,
                                        @RequestParam(defaultValue = "1") Integer page,
                                        @RequestParam(defaultValue = "10") Integer size){
        DateConverter dateConverter = new DateConverter();
        User u = (User) request.getSession().getAttribute("userinfo");
        Map<String,Object> map = (Map<String, Object>) info.get("info");
        int start = ((int) info.get("page") - 1) *(int) info.get("size");
        String keywords = info.get("keywords")+"";
        if(info.get("time")!=null && info.get("time")!=""){
            List time = (List) info.get("time");
            map.put("startTime", dateConverter.convert(time.get(0)+"").getTime());
            map.put("endTime",dateConverter.convert(time.get(1)+"").getTime());
        }

        map.put("id",u.getId());
        map.put("start",start);
        map.put("keywords",keywords);
        map.put("size",size);

        List<Performance> performance=baseInfoService.getPerformanceByUserId(map);
        int count = performance.size();
        Map<String,Object> res= new HashMap<>();
        res.put("count",count);
        res.put("performance",performance);

        return res;

    }

    @GetMapping("/getPerformanceByUserId")
    public Map<String,Object> getPerformanceByUserId(HttpServletRequest request,
                                              @RequestParam(defaultValue = "1") Integer page,
                                              @RequestParam(defaultValue = "10") Integer size){
        int start = (page - 1) * size;
        User u = (User) request.getSession().getAttribute("userinfo");
        Map<String,Object> map = new HashMap<>();
        map.put("id",u.getId());
        map.put("size",size);
        map.put("start",start);
        List<Performance> performance=baseInfoService.getPerformanceByUserId(map);
        int count = performance.size();
        Map<String,Object> res= new HashMap<>();
        res.put("count",count);
        res.put("performance",performance);

        return res;
    }




}
