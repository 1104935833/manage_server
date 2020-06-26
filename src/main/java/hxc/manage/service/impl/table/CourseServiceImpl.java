package hxc.manage.service.impl.table;

import hxc.manage.service.table.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import hxc.manage.model.table.Course;
import hxc.manage.mapper.CourseMapper;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Transactional(rollbackFor = Exception.class)
    public int insert(Course pojo){
        return courseMapper.insert(pojo);
    }

    @Transactional(rollbackFor = Exception.class)
    public int insertSelective(Course pojo){
        return courseMapper.insertSelective(pojo);
    }

    @Transactional(rollbackFor = Exception.class)
    public int insertList(List<Course> pojos){
        return courseMapper.insertList(pojos);
    }

    @Transactional(rollbackFor = Exception.class)
    public int update(Course pojo){
        return courseMapper.update(pojo);
    }

    @Override
    public Course getCourse(Map<String, Object> param) {
        return courseMapper.getCourse(param);
    }
}
