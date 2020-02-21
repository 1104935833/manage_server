package hxc.manage.service.impl;

import hxc.manage.service.AcademicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import hxc.manage.model.table.Academic;
import hxc.manage.mapper.AcademicMapper;

@Service
public class AcademicServiceImpl implements AcademicService {

    @Autowired
    private AcademicMapper academicMapper;

    public int insert(Academic pojo){
        return academicMapper.insert(pojo);
    }

    public int insertSelective(Academic pojo){
        return academicMapper.insertSelective(pojo);
    }

    public int insertList(List<Academic> pojos){
        return academicMapper.insertList(pojos);
    }

    public int update(Academic pojo){
        return academicMapper.update(pojo);
    }
}
