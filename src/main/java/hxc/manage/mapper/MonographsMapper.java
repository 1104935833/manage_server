package hxc.manage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import hxc.manage.model.table.Monographs;

@Mapper
public interface MonographsMapper {
    int insert(@Param("pojo") Monographs pojo);

    int insertSelective(@Param("pojo") Monographs pojo);

    int insertList(@Param("pojos") List<Monographs> pojo);

    int update(@Param("pojo") Monographs pojo);
}
