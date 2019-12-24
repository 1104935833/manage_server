package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.sang.bean.SysRole;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author hxc
 * @version 1.0
 * @date 2019/12/12 14:19
 */
@Mapper
@Component
public interface SysRoleMapper {


    List<SysRole> findSysRole();
}
