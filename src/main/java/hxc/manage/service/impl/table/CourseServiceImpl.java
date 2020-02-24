package hxc.manage.service.impl.table;

import hxc.manage.service.table.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import hxc.manage.model.table.Course;
import hxc.manage.mapper.CourseMapper;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    public int insert(Course pojo){
        return courseMapper.insert(pojo);
    }

    public int insertSelective(Course pojo){
        return courseMapper.insertSelective(pojo);
    }

    public int insertList(List<Course> pojos){
        return courseMapper.insertList(pojos);
    }

    public int update(Course pojo){
        return courseMapper.update(pojo);
    }

    @Override
    public Course getCourse(Map<String, Object> param) {
        return courseMapper.getCourse(param);
    }
}
