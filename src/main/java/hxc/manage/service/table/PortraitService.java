package hxc.manage.service.table;

import hxc.manage.model.table.Portrait;

import java.util.List;

public interface PortraitService {

    int insert(Portrait pojo);

    int insertSelective(Portrait pojo);

    int insertList(List<Portrait> pojos);

    int update(Portrait pojo);
}
