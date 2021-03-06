package hxc.manage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

import hxc.manage.model.table.Educational;

@Mapper
public interface EducationalMapper {
    int insert(@Param("pojo") Educational pojo);

    int insertSelective(@Param("pojo") Educational pojo);

    int insertList(@Param("pojos") List<Educational> pojo);

    int update(@Param("pojo") Educational pojo);

    Educational getEducational(@Param("pojo") Map<String, Object> param);

    List<Map<String, Object>> getList(@Param("map") Map<String, Object> map);
}
