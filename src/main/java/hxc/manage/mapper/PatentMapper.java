package hxc.manage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import hxc.manage.model.table.Patent;

@Mapper
public interface PatentMapper {
    int insert(@Param("pojo") Patent pojo);

    int insertSelective(@Param("pojo") Patent pojo);

    int insertList(@Param("pojos") List<Patent> pojo);

    int update(@Param("pojo") Patent pojo);
}
