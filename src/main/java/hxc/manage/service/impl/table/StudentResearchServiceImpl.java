package hxc.manage.service.impl.table;

import hxc.manage.service.table.StudentResearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import hxc.manage.model.table.StudentResearch;
import hxc.manage.mapper.StudentResearchMapper;

@Service
public class StudentResearchServiceImpl implements StudentResearchService {

    @Autowired
    private StudentResearchMapper studentResearchMapper;

    public int insert(StudentResearch pojo){
        return studentResearchMapper.insert(pojo);
    }

    public int insertSelective(StudentResearch pojo){
        return studentResearchMapper.insertSelective(pojo);
    }

    public int insertList(List<StudentResearch> pojos){
        return studentResearchMapper.insertList(pojos);
    }

    public int update(StudentResearch pojo){
        return studentResearchMapper.update(pojo);
    }

    @Override
    public StudentResearch getStudentResearchService(Map<String, Object> param) {
        return studentResearchMapper.getStudentResearchService(param);
    }
}
