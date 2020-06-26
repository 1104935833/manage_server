package hxc.manage.service.impl.table;

import hxc.manage.service.table.FirstSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import hxc.manage.model.table.FirstSubject;
import hxc.manage.mapper.FirstSubjectMapper;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FirstSubjectServiceImpl implements FirstSubjectService {

    @Autowired
    private FirstSubjectMapper firstSubjectMapper;

    @Transactional(rollbackFor = Exception.class)
    public int insert(FirstSubject pojo){
        return firstSubjectMapper.insert(pojo);
    }

    @Transactional(rollbackFor = Exception.class)
    public int insertSelective(FirstSubject pojo){
        return firstSubjectMapper.insertSelective(pojo);
    }

    @Transactional(rollbackFor = Exception.class)
    public int insertList(List<FirstSubject> pojos){
        return firstSubjectMapper.insertList(pojos);
    }

    @Transactional(rollbackFor = Exception.class)
    public int update(FirstSubject pojo){
        return firstSubjectMapper.update(pojo);
    }

    @Override
    public FirstSubject getFirstSubject(Map<String, Object> param) {
        return firstSubjectMapper.getFirstSubject(param);
    }
}
