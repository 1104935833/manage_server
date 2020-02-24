package hxc.manage.service.table;

import hxc.manage.model.table.Patent;

import java.util.List;

public interface PatentService {

    int insert(Patent pojo);

    int insertSelective(Patent pojo);

    int insertList(List<Patent> pojos);

    int update(Patent pojo);
}
