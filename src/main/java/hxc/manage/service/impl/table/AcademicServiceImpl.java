package hxc.manage.service.impl.table;

import hxc.manage.service.table.AcademicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

import hxc.manage.model.table.Academic;
import hxc.manage.mapper.AcademicMapper;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AcademicServiceImpl implements AcademicService {

    @Autowired
    private AcademicMapper academicMapper;

    @Transactional(rollbackFor = Exception.class)
    public int insert(Academic pojo){
        return academicMapper.insert(pojo);
    }

    @Transactional(rollbackFor = Exception.class)
    public int insertSelective(Academic pojo){
        return academicMapper.insertSelective(pojo);
    }

    @Transactional(rollbackFor = Exception.class)
    public int insertList(List<Academic> pojos){
        return academicMapper.insertList(pojos);
    }

    @Transactional(rollbackFor = Exception.class)
    public int update(Academic pojo){
        return academicMapper.update(pojo);
    }

    @Override
    public Academic getAcademic(Map<String, Object> param) {
        return academicMapper.getAcademic(param);
    }
}
