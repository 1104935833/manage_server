package org.sang.controller;

import org.sang.bean.SysMsg;
import org.sang.bean.SysRole;
import org.sang.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author hxc
 * @version 1.0
 * @date 2019/12/12 14:14
 */
@RestController
public class SysRoleController {

    @Autowired
    SysRoleService sysRoleService;


    @GetMapping("/sysrole")
    public List<SysRole> sysRole(){
        List<SysRole> list = sysRoleService.findSysRole();
        return list;

    }


}
