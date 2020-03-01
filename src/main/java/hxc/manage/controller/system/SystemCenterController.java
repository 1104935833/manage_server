package hxc.manage.controller.system;

import com.alibaba.druid.util.StringUtils;
import hxc.manage.common.EmailAndMessage;
import hxc.manage.model.RespBean;
import hxc.manage.model.User;
import hxc.manage.model.UserDetail;
import hxc.manage.service.SystemCenterService;
import hxc.manage.service.impl.UserServiceImpl;
import hxc.manage.util.RedisUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.awt.SystemColor.info;

@RestController
@RequestMapping("/center")
public class SystemCenterController {

    @Autowired
    SystemCenterService systemCenterService;




    @Autowired
    RedisUtil redisUtil;



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

    //近三年的个业绩比重
    @GetMapping("/PerforEchart")
    public List<Map<String, Object>> getPerforEcharts(HttpServletRequest request,@RequestParam(defaultValue = "3") int year){
        User u = (User) request.getSession().getAttribute("userinfo");
        List<Map<String, Object>> map = systemCenterService.getPerforEcharts(u.getUser_id(),year);
        return map;

    }

    //各业绩获得情况
    @GetMapping("/PerforEchart1")
    public List<Map<String, Object>> getPerforEcharts1(HttpServletRequest request){
        User u = (User) request.getSession().getAttribute("userinfo");
        List<Map<String, Object>> map = systemCenterService.getPerforEcharts1(u.getUser_id());
        return map;

    }

    //3大类业绩获得情况
    @GetMapping("/getPerformance")
    public Map<String, Object> getPerformance(HttpServletRequest request){
        User u = (User) request.getSession().getAttribute("userinfo");
        List<Map<String, Object>> map1 = systemCenterService.getPerformance(u.getUser_id(),"3","4");
        List<Map<String, Object>> map2 = systemCenterService.getPerformance(u.getUser_id(),"5","6");
        List<Map<String, Object>> map3 = systemCenterService.getPerformance(u.getUser_id(),"1","2");
        Map<String,Object> res= new HashMap<>();
        res.put("tableData1",map1);
        res.put("tableData2",map2);
        res.put("tableData3",map3);
        return res;

    }


    //获取审核各类型个数
    @GetMapping("/getCountAudit")
    public Map<String,Object> getCountAudit(HttpServletRequest request){
        User u = (User) request.getSession().getAttribute("userinfo");
        Map<String, Object> res = systemCenterService.getCountAudit(u.getUser_id());

        return res;
    }


}
