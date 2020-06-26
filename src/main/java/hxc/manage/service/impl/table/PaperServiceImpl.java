package hxc.manage.service.impl.table;

import hxc.manage.service.table.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import hxc.manage.model.table.Paper;
import hxc.manage.mapper.PaperMapper;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaperServiceImpl implements PaperService {

    @Autowired
    private PaperMapper paperMapper;

    @Transactional(rollbackFor = Exception.class)
    public int insert(Paper pojo){
        return paperMapper.insert(pojo);
    }

    @Transactional(rollbackFor = Exception.class)
    public int insertSelective(Paper pojo){
        return paperMapper.insertSelective(pojo);
    }

    @Transactional(rollbackFor = Exception.class)
    public int insertList(List<Paper> pojos){
        return paperMapper.insertList(pojos);
    }

    @Transactional(rollbackFor = Exception.class)
    public int update(Paper pojo){
        return paperMapper.update(pojo);
    }

    @Override
    public Paper getPaper(Map param) {

        return paperMapper.getPaper(param);
    }
}
