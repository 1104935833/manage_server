package hxc.manage.service.impl.table;

import hxc.manage.service.table.StudentResearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import hxc.manage.model.table.StudentResearch;
import hxc.manage.mapper.StudentResearchMapper;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentResearchServiceImpl implements StudentResearchService {

    @Autowired
    private StudentResearchMapper studentResearchMapper;

    @Transactional(rollbackFor = Exception.class)
    public int insert(StudentResearch pojo){
        return studentResearchMapper.insert(pojo);
    }

    @Transactional(rollbackFor = Exception.class)
    public int insertSelective(StudentResearch pojo){
        return studentResearchMapper.insertSelective(pojo);
    }

    @Transactional(rollbackFor = Exception.class)
    public int insertList(List<StudentResearch> pojos){
        return studentResearchMapper.insertList(pojos);
    }

    @Transactional(rollbackFor = Exception.class)
    public int update(StudentResearch pojo){
        return studentResearchMapper.update(pojo);
    }

    @Override
    public StudentResearch getStudentResearchService(Map<String, Object> param) {
        return studentResearchMapper.getStudentResearchService(param);
    }
}
