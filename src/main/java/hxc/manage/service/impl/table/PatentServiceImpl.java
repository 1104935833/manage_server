package hxc.manage.service.impl.table;

import hxc.manage.service.table.PatentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import hxc.manage.model.table.Patent;
import hxc.manage.mapper.PatentMapper;

@Service
public class PatentServiceImpl implements PatentService {

    @Autowired
    private PatentMapper patentMapper;

    public int insert(Patent pojo){
        return patentMapper.insert(pojo);
    }

    public int insertSelective(Patent pojo){
        return patentMapper.insertSelective(pojo);
    }

    public int insertList(List<Patent> pojos){
        return patentMapper.insertList(pojos);
    }

    public int update(Patent pojo){
        return patentMapper.update(pojo);
    }
}
