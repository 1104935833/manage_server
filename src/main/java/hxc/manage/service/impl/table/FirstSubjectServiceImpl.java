package hxc.manage.service.impl.table;

import hxc.manage.service.table.FirstSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import hxc.manage.model.table.FirstSubject;
import hxc.manage.mapper.FirstSubjectMapper;

@Service
public class FirstSubjectServiceImpl implements FirstSubjectService {

    @Autowired
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
}
