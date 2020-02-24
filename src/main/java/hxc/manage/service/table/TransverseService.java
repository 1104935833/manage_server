package hxc.manage.service.table;

import hxc.manage.model.table.Transverse;

import java.util.List;
import java.util.Map;

public interface TransverseService {

    int insert(Transverse pojo);

    int insertSelective(Transverse pojo);

    int insertList(List<Transverse> pojos);

    int update(Transverse pojo);

    Transverse getTransverse(Map<String,Object> param);
}
