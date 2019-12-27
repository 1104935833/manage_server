package hxc.manage.controller.system;

import hxc.manage.service.RoleService;
import hxc.manage.model.User;
import hxc.manage.model.RespBean;
import hxc.manage.model.Role;
import hxc.manage.service.impl.UserServiceImpl;
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
    UserServiceImpl userServiceImpl;
    @Autowired
    RoleService roleService;

    @RequestMapping("/id/{hrId}")
    public User getHrById(@PathVariable Long hrId) {
        return userServiceImpl.getHrById(hrId);
    }

    @RequestMapping(value = "/{hrId}", method = RequestMethod.DELETE)
    public RespBean deleteHr(@PathVariable Long hrId) {
        if (userServiceImpl.deleteHr(hrId) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public RespBean updateHr(User user) {
        if (userServiceImpl.updateHr(user) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @RequestMapping(value = "/roles", method = RequestMethod.PUT)
    public RespBean updateHrRoles(Long hrId, Long[] rids) {
        if (userServiceImpl.updateHrRoles(hrId, rids) == rids.length) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @RequestMapping("/{keywords}")
    public List<User> getHrsByKeywords(@PathVariable(required = false) String keywords) {
        List<User> users = userServiceImpl.getHrsByKeywords(keywords);
        return users;
    }

    @RequestMapping(value = "/roles",method = RequestMethod.GET)
    public List<Role> allRoles() {
        return roleService.roles();
    }

    @RequestMapping(value = "/hr/reg", method = RequestMethod.POST)
    public RespBean hrReg(String username, String password) {
        int i = userServiceImpl.userReg(username, password);
        if (i == 1) {
            return RespBean.ok("注册成功!");
        } else if (i == -1) {
            return RespBean.error("用户名重复，注册失败!");
        }
        return RespBean.error("注册失败!");
    }

}
