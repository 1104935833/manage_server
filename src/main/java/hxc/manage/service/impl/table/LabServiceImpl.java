package hxc.manage.service.impl.table;

import hxc.manage.service.table.LabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import hxc.manage.model.table.Lab;
import hxc.manage.mapper.LabMapper;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LabServiceImpl implements LabService {

    @Autowired
    private LabMapper labMapper;

    @Transactional(rollbackFor = Exception.class)
    public int insert(Lab pojo){
        return labMapper.insert(pojo);
    }

    @Transactional(rollbackFor = Exception.class)
    public int insertSelective(Lab pojo){
        return labMapper.insertSelective(pojo);
    }

    @Transactional(rollbackFor = Exception.class)
    public int insertList(List<Lab> pojos){
        return labMapper.insertList(pojos);
    }

    @Transactional(rollbackFor = Exception.class)
    public int update(Lab pojo){
        return labMapper.update(pojo);
    }

    @Override
    public Lab getLab(Map<String, Object> param) {
        return labMapper.getLab(param);

    }
}
