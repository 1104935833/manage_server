package hxc.manage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

import hxc.manage.model.table.Monographs;

@Mapper
public interface MonographsMapper {
    int insert(@Param("pojo") Monographs pojo);

    int insertSelective(@Param("pojo") Monographs pojo);

    int insertList(@Param("pojos") List<Monographs> pojo);

    int update(@Param("pojo") Monographs pojo);

    Monographs getMonographs(@Param("pojo") Map<String, Object> param);

    List<Map<String, Object>> getList(@Param("map") Map<String, Object> map);
}
