package hxc.manage.service.impl.table;

import hxc.manage.service.table.HonerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import hxc.manage.model.table.Honer;
import hxc.manage.mapper.HonerMapper;

@Service
public class HonerServiceImpl implements HonerService {

    @Autowired
    private HonerMapper honerMapper;

    public int insert(Honer pojo){
        return honerMapper.insert(pojo);
    }

    public int insertSelective(Honer pojo){
        return honerMapper.insertSelective(pojo);
    }

    public int insertList(List<Honer> pojos){
        return honerMapper.insertList(pojos);
    }

    public int update(Honer pojo){
        return honerMapper.update(pojo);
    }

    public List<Map<String, Object>> searchHoner(Map param) {
        return honerMapper.searchAllHoner(param);
    }

}
