package hxc.manage.controller.system;

import com.alibaba.druid.util.StringUtils;
import hxc.manage.common.EmailAndMessage;
import hxc.manage.model.RespBean;
import hxc.manage.model.User;
import hxc.manage.service.SystemCenterService;
import hxc.manage.service.impl.UserServiceImpl;
import hxc.manage.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

import static java.awt.SystemColor.info;

@RestController
@RequestMapping("/center")
public class SystemCenterController {

    @Autowired
    SystemCenterService systemCenterService;

    @Autowired
    UserServiceImpl userServiceImpl;


    @Autowired
    RedisUtil redisUtil;

    @PostMapping("/changeInfo")
    public RespBean changeInfo(@RequestBody Map info,HttpServletRequest request){
        try {
            User  user = new User();
            Map<String, String> map = (Map<String, String>) info.get("info");
            User u = (User) request.getSession().getAttribute("userinfo");
            map.put("id", u.getId() + "");
            int i = systemCenterService.changeInfo(map);
            if(i>0){
                user= (User) userServiceImpl.loadUserByUsername(u.getWorkID());
            }

            return RespBean.ok("修改成功",user);
        }catch (Exception e){
            e.printStackTrace();
            return RespBean.error("修改失败");
        }
    }

    @PostMapping("/editPwd")
    public  RespBean editPwd(@RequestParam("yzm") String yzm,@RequestParam("newPwd") String newPwd,HttpServletRequest request){
        User u = (User) request.getSession().getAttribute("userinfo");
        if(StringUtils.equals(redisUtil.get("yzm")+"",yzm)){
            systemCenterService.editPwd(yzm,newPwd,u.getId());
            return RespBean.ok("修改成功");
        }else{
            return RespBean.error("验证码错误");
        }

    }

    @GetMapping("/getYzm")
    public RespBean getYzm(@RequestParam("phone") String phone){

        systemCenterService.getYzm(phone);


        return RespBean.ok("已发送");

    }
}
