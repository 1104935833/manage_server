package hxc.manage.service.impl.table;

import hxc.manage.service.table.TeachingReformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import hxc.manage.model.table.TeachingReform;
import hxc.manage.mapper.TeachingReformMapper;

@Service
public class TeachingReformServiceImpl implements TeachingReformService {

    @Autowired
    private TeachingReformMapper teachingReformMapper;

    public int insert(TeachingReform pojo){
        return teachingReformMapper.insert(pojo);
    }

    public int insertSelective(TeachingReform pojo){
        return teachingReformMapper.insertSelective(pojo);
    }

    public int insertList(List<TeachingReform> pojos){
        return teachingReformMapper.insertList(pojos);
    }

    public int update(TeachingReform pojo){
        return teachingReformMapper.update(pojo);
    }

    @Override
    public TeachingReform getTeachingReform(Map<String, Object> param) {
        return teachingReformMapper.getTeachingReform(param);
    }
}
