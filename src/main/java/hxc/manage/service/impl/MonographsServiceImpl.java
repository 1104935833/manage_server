package hxc.manage.service.impl;

import hxc.manage.service.MonographsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import hxc.manage.model.table.Monographs;
import hxc.manage.mapper.MonographsMapper;

@Service
public class MonographsServiceImpl implements MonographsService {

    @Autowired
    private MonographsMapper monographsMapper;

    public int insert(Monographs pojo){
        return monographsMapper.insert(pojo);
    }

    public int insertSelective(Monographs pojo){
        return monographsMapper.insertSelective(pojo);
    }

    public int insertList(List<Monographs> pojos){
        return monographsMapper.insertList(pojos);
    }

    public int update(Monographs pojo){
        return monographsMapper.update(pojo);
    }

    @Override
    public List<Map<String, Object>> getMonographs(Map param) {

        return monographsMapper.getMonographs(param);
    }
}
