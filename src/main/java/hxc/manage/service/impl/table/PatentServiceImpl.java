package hxc.manage.service.impl.table;

import hxc.manage.service.table.PatentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import hxc.manage.model.table.Patent;
import hxc.manage.mapper.PatentMapper;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PatentServiceImpl implements PatentService {

    @Autowired
    private PatentMapper patentMapper;

    @Transactional(rollbackFor = Exception.class)
    public int insert(Patent pojo){
        return patentMapper.insert(pojo);
    }

    @Transactional(rollbackFor = Exception.class)
    public int insertSelective(Patent pojo){
        return patentMapper.insertSelective(pojo);
    }

    @Transactional(rollbackFor = Exception.class)
    public int insertList(List<Patent> pojos){
        return patentMapper.insertList(pojos);
    }

    @Transactional(rollbackFor = Exception.class)
    public int update(Patent pojo){
        return patentMapper.update(pojo);
    }

    @Override
    public Patent getPatent(Map<String, Object> param) {
        return patentMapper.getPatent(param);
    }
}
