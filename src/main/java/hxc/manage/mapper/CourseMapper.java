package hxc.manage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

import hxc.manage.model.table.Course;

@Mapper
public interface CourseMapper {
    int insert(@Param("pojo") Course pojo);

    int insertSelective(@Param("pojo") Course pojo);

    int insertList(@Param("pojos") List<Course> pojo);

    int update(@Param("pojo") Course pojo);

    Course getCourse(@Param("pojo") Map<String, Object> param);
}
