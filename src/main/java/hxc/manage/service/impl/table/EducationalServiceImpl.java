package hxc.manage.service.impl.table;

import hxc.manage.service.table.EducationalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import hxc.manage.model.table.Educational;
import hxc.manage.mapper.EducationalMapper;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EducationalServiceImpl implements EducationalService {

    @Autowired
    private EducationalMapper educationalMapper;

    @Transactional(rollbackFor = Exception.class)
    public int insert(Educational pojo){
        return educationalMapper.insert(pojo);
    }

    @Transactional(rollbackFor = Exception.class)
    public int insertSelective(Educational pojo){
        return educationalMapper.insertSelective(pojo);
    }

    @Transactional(rollbackFor = Exception.class)
    public int insertList(List<Educational> pojos){
        return educationalMapper.insertList(pojos);
    }

    @Transactional(rollbackFor = Exception.class)
    public int update(Educational pojo){
        return educationalMapper.update(pojo);
    }

    @Override
    public Educational getEducational(Map<String, Object> param) {
        return educationalMapper.getEducational(param);
    }
}
