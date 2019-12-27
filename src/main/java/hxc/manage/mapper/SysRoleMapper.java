package hxc.manage.mapper;

import org.apache.ibatis.annotations.Mapper;
import hxc.manage.model.SysRole;
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
