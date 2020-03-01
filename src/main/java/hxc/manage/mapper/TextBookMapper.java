package hxc.manage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

import hxc.manage.model.table.TextBook;

@Mapper
public interface TextBookMapper {
    int insert(@Param("pojo") TextBook pojo);

    int insertSelective(@Param("pojo") TextBook pojo);

    int insertList(@Param("pojos") List<TextBook> pojo);

    int update(@Param("pojo") TextBook pojo);

    TextBook getTextBook(@Param("pojo") Map<String, Object> param);

    List<Map<String, Object>> getList(@Param("map") Map<String, Object> map);
}
