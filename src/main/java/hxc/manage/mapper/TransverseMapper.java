package hxc.manage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import hxc.manage.model.table.Transverse;

@Mapper
public interface TransverseMapper {
    int insert(@Param("pojo") Transverse pojo);

    int insertSelective(@Param("pojo") Transverse pojo);

    int insertList(@Param("pojos") List<Transverse> pojo);

    int update(@Param("pojo") Transverse pojo);
}
