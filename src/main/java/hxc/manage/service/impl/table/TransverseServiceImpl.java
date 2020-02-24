package hxc.manage.service.impl.table;

import hxc.manage.service.table.TransverseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import hxc.manage.model.table.Transverse;
import hxc.manage.mapper.TransverseMapper;

@Service
public class TransverseServiceImpl implements TransverseService {

    @Autowired
    private TransverseMapper transverseMapper;

    public int insert(Transverse pojo){
        return transverseMapper.insert(pojo);
    }

    public int insertSelective(Transverse pojo){
        return transverseMapper.insertSelective(pojo);
    }

    public int insertList(List<Transverse> pojos){
        return transverseMapper.insertList(pojos);
    }

    public int update(Transverse pojo){
        return transverseMapper.update(pojo);
    }
}
