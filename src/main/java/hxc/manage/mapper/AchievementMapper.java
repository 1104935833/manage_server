package hxc.manage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import hxc.manage.model.table.Achievement;

@Mapper
public interface AchievementMapper {
    int insert(@Param("pojo") Achievement pojo);

    int insertSelective(@Param("pojo") Achievement pojo);

    int insertList(@Param("pojos") List<Achievement> pojo);

    int update(@Param("pojo") Achievement pojo);
}
