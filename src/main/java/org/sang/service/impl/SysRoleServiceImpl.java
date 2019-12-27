package org.sang.service.impl;

import org.sang.model.SysRole;
import org.sang.mapper.SysRoleMapper;
import org.sang.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hxc
 * @version 1.0
 * @date 2019/12/12 14:17
 */
@Service
public class SysRoleServiceImpl  implements SysRoleService {

    @Autowired
    SysRoleMapper sysRoleMapper;

    public List<SysRole> findSysRole(){

        return sysRoleMapper.findSysRole();
    }
}
