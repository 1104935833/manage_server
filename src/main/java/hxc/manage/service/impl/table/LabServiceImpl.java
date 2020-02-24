package hxc.manage.service.impl.table;

import hxc.manage.service.table.LabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import hxc.manage.model.table.Lab;
import hxc.manage.mapper.LabMapper;

@Service
public class LabServiceImpl implements LabService {

    @Autowired
    private LabMapper labMapper;

    public int insert(Lab pojo){
        return labMapper.insert(pojo);
    }

    public int insertSelective(Lab pojo){
        return labMapper.insertSelective(pojo);
    }

    public int insertList(List<Lab> pojos){
        return labMapper.insertList(pojos);
    }

    public int update(Lab pojo){
        return labMapper.update(pojo);
    }
}
