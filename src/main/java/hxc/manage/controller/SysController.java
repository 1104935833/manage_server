package hxc.manage.controller;

import hxc.manage.model.Pedding;
import hxc.manage.model.Role;
import hxc.manage.model.User;
import hxc.manage.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author hxc
 * @version 1.0
 * @date 2019/12/12 14:14
 */
@RestController
public class SysController {

    @Autowired
    SysRoleService sysRoleService;

//
//    @GetMapping("/sysrole")
//    public List<SysRole> sysRole(){
//        List<SysRole> list = sysRoleService.findSysRole();
//        return list;
//
//    }

    //获取待办
    @GetMapping("/getPeddingName")
    public Map<String,List> getPeddingName(HttpServletRequest req){
        User user = (User) req.getSession().getAttribute("userinfo");
        List<Role> roles =user.getRoles();
        String userId =user.getId()+"";
        Map<String, List> map = sysRoleService.getPeddingName(roles,userId);
        return map;
    }

    //发送消除待办
    @GetMapping("/sendPedding")
    public Map<String, String> sendPedding(HttpServletRequest req,
                                               @RequestParam("tableId") String tableId,
                                               @RequestParam("type")String type,
                                               @RequestParam("agree")String agree,
                                               @RequestParam("state")String state) {
        int res;
//        state 到哪个阶段了1首次发起2教研室3分院4返回修改在发起
        User user = (User) req.getSession().getAttribute("userinfo");
        String userId =user.getId()+"";
        //第一次直接插入记录就好
        Pedding pedding = new Pedding();
        if (state.equals("1")) {
            pedding.setType(type);//个人or集体;1,2
            pedding.setMain("有一条xxx的需要审核");
            pedding.setName("审核");
            pedding.setState("0");
            pedding.setTableId(tableId);
            pedding.setUrl("/sys/center");
            pedding.setOperator(userId);
            pedding.setCreateTime(new Date().getTime() + "");
            res = sysRoleService.sendPedding(pedding, userId, "", state);
        }else{
            pedding.setUpdateTime(new Date().getTime()+"");
            pedding.setTableId(tableId);
            res = sysRoleService.sendPedding(pedding,userId,agree,state);
        }
        Map<String,String> map = new HashMap<>();
        if(res>0){
            map.put("msg","修改成功");
            map.put("stats","200");
            return map;
        }else{
            map.put("msg","修改失败");
            map.put("stats","500");
            return map;
        }



    }



}
