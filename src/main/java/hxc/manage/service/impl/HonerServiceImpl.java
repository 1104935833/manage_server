package hxc.manage.service.impl;

import hxc.manage.service.HonerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import hxc.manage.model.Honer;
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
}
