package hxc.manage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import hxc.manage.model.table.Technological;

@Mapper
public interface TechnologicalMapper {
    int insert(@Param("pojo") Technological pojo);

    int insertSelective(@Param("pojo") Technological pojo);

    int insertList(@Param("pojos") List<Technological> pojo);

    int update(@Param("pojo") Technological pojo);
}
