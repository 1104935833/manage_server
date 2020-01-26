package hxc.manage.mapper;

import hxc.manage.model.Pedding;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author hxc
 * @version 1.0
 * @date 2019/12/12 14:19
 */
@Mapper
@Component
public interface SysRoleMapper {


//    List<SysRole> findSysRole();

    List<Map<String, Object>> getPeddingName(@Param("id") String id);

    List<Map<String, Object>> getPeddingName2(@Param("userId") String userId);

    Integer sendPedding(Pedding pedding);

    String findPeddingRole(@Param("userId") String userId);

    Integer updatePedding(Pedding pedding);
}
