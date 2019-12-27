package hxc.manage.service.impl;

import hxc.manage.mapper.SysRoleMapper;
import hxc.manage.service.SysRoleService;
import hxc.manage.model.SysRole;
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
