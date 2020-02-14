package hxc.manage.controller;

import hxc.manage.model.Role;
import hxc.manage.model.User;
import hxc.manage.service.PeddingService;
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
public class PeddingController {

    @Autowired
    PeddingService peddingService;



//
//    @GetMapping("/sysrole")
//    public List<SysRole> sysRole(){
//        List<SysRole> list = peddingService.findSysRole();
//        return list;
//
//    }



    //获取待办
    @GetMapping("/getPeddingName")
    public Map<String,Object> getPeddingName(HttpServletRequest req,@RequestParam(defaultValue = "1") Integer page,
                                           @RequestParam(defaultValue = "10") Integer size) {
        int start = (page - 1) * size;
        User user = (User) req.getSession().getAttribute("userinfo");
        List<Role> roles =user.getRoles();
        String userId =user.getId()+"";

        Map<String, Object> map = peddingService.getPeddingName(roles,userId,size,start);
        return map;
    }




}
