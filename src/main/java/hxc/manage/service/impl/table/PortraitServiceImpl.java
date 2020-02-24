package hxc.manage.service.impl.table;

import hxc.manage.service.table.PortraitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import hxc.manage.model.table.Portrait;
import hxc.manage.mapper.PortraitMapper;

@Service
public class PortraitServiceImpl implements PortraitService {

    @Autowired
    private PortraitMapper portraitMapper;

    public int insert(Portrait pojo){
        return portraitMapper.insert(pojo);
    }

    public int insertSelective(Portrait pojo){
        return portraitMapper.insertSelective(pojo);
    }

    public int insertList(List<Portrait> pojos){
        return portraitMapper.insertList(pojos);
    }

    public int update(Portrait pojo){
        return portraitMapper.update(pojo);
    }
}
