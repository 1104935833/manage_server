package hxc.manage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

import hxc.manage.model.table.Technological;

@Mapper
public interface TechnologicalMapper {
    int insert(@Param("pojo") Technological pojo);

    int insertSelective(@Param("pojo") Technological pojo);

    int insertList(@Param("pojos") List<Technological> pojo);

    int update(@Param("pojo") Technological pojo);

    Technological getTechnological(@Param("pojo") Map<String, Object> param);

    List<Map<String, Object>> getList(@Param("map") Map<String, Object> map);
}
