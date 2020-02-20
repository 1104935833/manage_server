package hxc.manage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import hxc.manage.model.table.Portrait;

@Mapper
public interface PortraitMapper {
    int insert(@Param("pojo") Portrait pojo);

    int insertSelective(@Param("pojo") Portrait pojo);

    int insertList(@Param("pojos") List<Portrait> pojo);

    int update(@Param("pojo") Portrait pojo);
}
