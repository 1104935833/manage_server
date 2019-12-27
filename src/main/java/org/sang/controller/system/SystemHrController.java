package org.sang.controller.system;

import org.sang.model.User;
import org.sang.model.RespBean;
import org.sang.model.Role;
import org.sang.service.UserService;
import org.sang.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by sang on 2018/1/2.
 */
@RestController
@RequestMapping("/system/hr")
public class SystemHrController {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    @RequestMapping("/id/{hrId}")
    public User getHrById(@PathVariable Long hrId) {
        return userService.getHrById(hrId);
    }

    @RequestMapping(value = "/{hrId}", method = RequestMethod.DELETE)
    public RespBean deleteHr(@PathVariable Long hrId) {
        if (userService.deleteHr(hrId) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public RespBean updateHr(User user) {
        if (userService.updateHr(user) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @RequestMapping(value = "/roles", method = RequestMethod.PUT)
    public RespBean updateHrRoles(Long hrId, Long[] rids) {
        if (userService.updateHrRoles(hrId, rids) == rids.length) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @RequestMapping("/{keywords}")
    public List<User> getHrsByKeywords(@PathVariable(required = false) String keywords) {
        List<User> users = userService.getHrsByKeywords(keywords);
        return users;
    }

    @RequestMapping(value = "/roles",method = RequestMethod.GET)
    public List<Role> allRoles() {
        return roleService.roles();
    }

    @RequestMapping(value = "/hr/reg", method = RequestMethod.POST)
    public RespBean hrReg(String username, String password) {
        int i = userService.userReg(username, password);
        if (i == 1) {
            return RespBean.ok("注册成功!");
        } else if (i == -1) {
            return RespBean.error("用户名重复，注册失败!");
        }
        return RespBean.error("注册失败!");
    }

}
