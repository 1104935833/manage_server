package hxc.manage.mapper;

import hxc.manage.model.Pedding;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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


//    List<SysRole> findSysRole();

    List<Pedding> getPeddingName(@Param("id") String id, @Param("size") int size, @Param("start") int start);

    List<Pedding> getPeddingName2(@Param("userId") String userId, @Param("size") int size, @Param("start") int start);

    Integer sendPedding(Pedding pedding);

    String findPeddingRole(@Param("userId") String userId);

    Integer updatePedding(Pedding pedding);
}
