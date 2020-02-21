package hxc.manage.service.impl;

import hxc.manage.service.TechnologicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import hxc.manage.model.table.Technological;
import hxc.manage.mapper.TechnologicalMapper;

@Service
public class TechnologicalServiceImpl implements TechnologicalService {

    @Autowired
    private TechnologicalMapper technologicalMapper;

    public int insert(Technological pojo){
        return technologicalMapper.insert(pojo);
    }

    public int insertSelective(Technological pojo){
        return technologicalMapper.insertSelective(pojo);
    }

    public int insertList(List<Technological> pojos){
        return technologicalMapper.insertList(pojos);
    }

    public int update(Technological pojo){
        return technologicalMapper.update(pojo);
    }

    @Override
    public List<Map<String, Object>> getTechnologicals(Map param) {
        return technologicalMapper.getTechnologicals(param);
    }
}
