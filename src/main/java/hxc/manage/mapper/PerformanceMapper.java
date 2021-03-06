package hxc.manage.mapper;

import hxc.manage.model.Table;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface PerformanceMapper {

    List<Map<String,Object>> getPerformanceByUserId(@Param("map") Map<String,Object> map);


    List<Table> getTableByUserId(@Param("id")String id);

    Map<String,Object> getPerformanceByUserId1(@Param("map") Map<String,Object> map);

    Map<String, Object> getCountAudit(String user_id);

    List<Map<String,Object>> getperType(@Param("state") String state,@Param("id") String id,@Param("group") String group);

    List<Map<String, Object>> searchPerNameNotNull(@Param("map") Map<String, Object> map);
}
