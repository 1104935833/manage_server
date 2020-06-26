package hxc.manage.service.impl.table;

import hxc.manage.service.table.MonographsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import hxc.manage.model.table.Monographs;
import hxc.manage.mapper.MonographsMapper;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MonographsServiceImpl implements MonographsService {

    @Autowired
    private MonographsMapper monographsMapper;

    @Transactional(rollbackFor = Exception.class)
    public int insert(Monographs pojo){
        return monographsMapper.insert(pojo);
    }

    @Transactional(rollbackFor = Exception.class)
    public int insertSelective(Monographs pojo){
        return monographsMapper.insertSelective(pojo);
    }

    @Transactional(rollbackFor = Exception.class)
    public int insertList(List<Monographs> pojos){
        return monographsMapper.insertList(pojos);
    }

    @Transactional(rollbackFor = Exception.class)
    public int update(Monographs pojo){
        return monographsMapper.update(pojo);
    }

    @Override
    public Monographs getMonographs(Map<String, Object> param) {
        return monographsMapper.getMonographs(param);
    }
}
