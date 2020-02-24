package hxc.manage.service.table;

import hxc.manage.model.table.Course;

import java.util.List;

public interface CourseService {

    int insert(Course pojo);

    int insertSelective(Course pojo);

    int insertList(List<Course> pojos);

    int update(Course pojo);
}
