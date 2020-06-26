package hxc.manage.service.impl.table;

import hxc.manage.service.table.PortraitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import hxc.manage.model.table.Portrait;
import hxc.manage.mapper.PortraitMapper;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PortraitServiceImpl implements PortraitService {

    @Autowired
    private PortraitMapper portraitMapper;

    @Transactional(rollbackFor = Exception.class)
    public int insert(Portrait pojo){
        return portraitMapper.insert(pojo);
    }

    @Transactional(rollbackFor = Exception.class)
    public int insertSelective(Portrait pojo){
        return portraitMapper.insertSelective(pojo);
    }

    @Transactional(rollbackFor = Exception.class)
    public int insertList(List<Portrait> pojos){
        return portraitMapper.insertList(pojos);
    }

    @Transactional(rollbackFor = Exception.class)
    public int update(Portrait pojo){
        return portraitMapper.update(pojo);
    }

    @Override
    public Portrait getPortrait(Map<String, Object> param) {
        return portraitMapper.getPortrait(param);
    }
}
