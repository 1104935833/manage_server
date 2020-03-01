package hxc.manage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

import hxc.manage.model.table.Academic;

@Mapper
public interface AcademicMapper {
    int insert(@Param("pojo") Academic pojo);

    int insertSelective(@Param("pojo") Academic pojo);

    int insertList(@Param("pojos") List<Academic> pojo);

    int update(@Param("pojo") Academic pojo);

    Academic getAcademic(@Param("pojo") Map<String, Object> param);

    List<Map<String, Object>> getList(@Param("map") Map<String, Object> map);
}
