package hxc.manage.service.impl;

import hxc.manage.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import hxc.manage.model.table.Paper;
import hxc.manage.mapper.PaperMapper;

@Service
public class PaperServiceImpl implements PaperService {

    @Autowired
    private PaperMapper paperMapper;

    public int insert(Paper pojo){
        return paperMapper.insert(pojo);
    }

    public int insertSelective(Paper pojo){
        return paperMapper.insertSelective(pojo);
    }

    public int insertList(List<Paper> pojos){
        return paperMapper.insertList(pojos);
    }

    public int update(Paper pojo){
        return paperMapper.update(pojo);
    }
}
