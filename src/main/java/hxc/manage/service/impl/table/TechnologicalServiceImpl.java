package hxc.manage.service.impl.table;

import hxc.manage.service.table.TechnologicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import hxc.manage.model.table.Technological;
import hxc.manage.mapper.TechnologicalMapper;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TechnologicalServiceImpl implements TechnologicalService {

    @Autowired
    private TechnologicalMapper technologicalMapper;

    @Transactional(rollbackFor = Exception.class)
    public int insert(Technological pojo){
        return technologicalMapper.insert(pojo);
    }

    @Transactional(rollbackFor = Exception.class)
    public int insertSelective(Technological pojo){
        return technologicalMapper.insertSelective(pojo);
    }

    @Transactional(rollbackFor = Exception.class)
    public int insertList(List<Technological> pojos){
        return technologicalMapper.insertList(pojos);
    }

    @Transactional(rollbackFor = Exception.class)
    public int update(Technological pojo){
        return technologicalMapper.update(pojo);
    }

    @Override
    public Technological getTechnological(Map<String, Object> param) {
        return technologicalMapper.getTechnological(param);

    }
}
