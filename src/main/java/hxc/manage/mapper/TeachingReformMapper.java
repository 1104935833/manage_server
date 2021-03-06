package hxc.manage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

import hxc.manage.model.table.TeachingReform;

@Mapper
public interface TeachingReformMapper {
    int insert(@Param("pojo") TeachingReform pojo);

    int insertSelective(@Param("pojo") TeachingReform pojo);

    int insertList(@Param("pojos") List<TeachingReform> pojo);

    int update(@Param("pojo") TeachingReform pojo);

    TeachingReform getTeachingReform(@Param("pojo") Map<String, Object> param);

    List<Map<String, Object>> getList(@Param("map") Map<String, Object> map);
}
