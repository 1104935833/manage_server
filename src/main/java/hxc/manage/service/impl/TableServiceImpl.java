package hxc.manage.service.impl;

import hxc.manage.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import hxc.manage.model.Table;
import hxc.manage.mapper.TableMapper;

@Service
public class TableServiceImpl implements TableService {

    @Autowired
    private TableMapper tableMapper;

    public int insert(Table pojo){
        return tableMapper.insert(pojo);
    }

    public int insertSelective(Table pojo){
        return tableMapper.insertSelective(pojo);
    }

    public int insertList(List<Table> pojos){
        return tableMapper.insertList(pojos);
    }

    public int update(Table pojo){
        return tableMapper.update(pojo);
    }
}
