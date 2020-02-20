package hxc.manage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import hxc.manage.model.table.PatentInvent;

@Mapper
public interface PaentInventMapper {
    int insert(@Param("pojo") PatentInvent pojo);

    int insertSelective(@Param("pojo") PatentInvent pojo);

    int insertList(@Param("pojos") List<PatentInvent> pojo);

    int update(@Param("pojo") PatentInvent pojo);
}
