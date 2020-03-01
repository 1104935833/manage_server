package hxc.manage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

import hxc.manage.model.table.Professional;

@Mapper
public interface ProfessionalMapper {
    int insert(@Param("pojo") Professional pojo);

    int insertSelective(@Param("pojo") Professional pojo);

    int insertList(@Param("pojos") List<Professional> pojo);

    int update(@Param("pojo") Professional pojo);

    Professional getProfessional(@Param("pojo") Map<String, Object> param);

    List<Map<String, Object>> getList(@Param("map") Map<String, Object> map);
}
