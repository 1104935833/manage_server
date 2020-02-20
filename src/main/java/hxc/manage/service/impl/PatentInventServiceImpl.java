package hxc.manage.service.impl;

import hxc.manage.service.PatentInventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import hxc.manage.model.table.PatentInvent;
import hxc.manage.mapper.PaentInventMapper;

@Service
public class PatentInventServiceImpl implements PatentInventService {

    @Autowired
    private PaentInventMapper patentInventMapper;

    public int insert(PatentInvent pojo){
        return patentInventMapper.insert(pojo);
    }

    public int insertSelective(PatentInvent pojo){
        return patentInventMapper.insertSelective(pojo);
    }

    public int insertList(List<PatentInvent> pojos){
        return patentInventMapper.insertList(pojos);
    }

    public int update(PatentInvent pojo){
        return patentInventMapper.update(pojo);
    }
}
