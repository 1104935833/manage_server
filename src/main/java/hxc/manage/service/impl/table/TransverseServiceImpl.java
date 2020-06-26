package hxc.manage.service.impl.table;

import hxc.manage.service.table.TransverseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import hxc.manage.model.table.Transverse;
import hxc.manage.mapper.TransverseMapper;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransverseServiceImpl implements TransverseService {

    @Autowired
    private TransverseMapper transverseMapper;

    @Transactional(rollbackFor = Exception.class)
    public int insert(Transverse pojo){
        return transverseMapper.insert(pojo);
    }

    @Transactional(rollbackFor = Exception.class)
    public int insertSelective(Transverse pojo){
        return transverseMapper.insertSelective(pojo);
    }

    @Transactional(rollbackFor = Exception.class)
    public int insertList(List<Transverse> pojos){
        return transverseMapper.insertList(pojos);
    }

    @Transactional(rollbackFor = Exception.class)
    public int update(Transverse pojo){
        return transverseMapper.update(pojo);
    }

    @Override
    public Transverse getTransverse(Map<String, Object> param) {
        return transverseMapper.getTransverse(param);
    }
}
