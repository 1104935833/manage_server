package hxc.manage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import hxc.manage.model.table.Lab;

@Mapper
public interface LabMapper {
    int insert(@Param("pojo") Lab pojo);

    int insertSelective(@Param("pojo") Lab pojo);

    int insertList(@Param("pojos") List<Lab> pojo);

    int update(@Param("pojo") Lab pojo);
}
