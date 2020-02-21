package hxc.manage.service.impl;

import hxc.manage.service.FirstSubjectService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import hxc.manage.model.table.FirstSubject;
import hxc.manage.mapper.FirstSubjectMapper;

@Service
public class FirstSubjectServiceImpl implements FirstSubjectService {

    @Resource
    private FirstSubjectMapper firstSubjectMapper;

    public int insert(FirstSubject pojo){
        return firstSubjectMapper.insert(pojo);
    }

    public int insertSelective(FirstSubject pojo){
        return firstSubjectMapper.insertSelective(pojo);
    }

    public int insertList(List<FirstSubject> pojos){
        return firstSubjectMapper.insertList(pojos);
    }

    public int update(FirstSubject pojo){
        return firstSubjectMapper.update(pojo);
    }

    @Override
    public List<Map<String,Object>> getFirstSubjects(Map param){
        return firstSubjectMapper.getFirstSubjects(param);
    }
}
