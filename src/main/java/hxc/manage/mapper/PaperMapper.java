package hxc.manage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

import hxc.manage.model.table.Paper;

@Mapper
public interface PaperMapper {
    int insert(@Param("pojo") Paper pojo);

    int insertSelective(@Param("pojo") Paper pojo);

    int insertList(@Param("pojos") List<Paper> pojo);

    int update(@Param("pojo") Paper pojo);

    Paper getPaper(@Param("pojo") Map param);
}
