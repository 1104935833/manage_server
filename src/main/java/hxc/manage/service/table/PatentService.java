package hxc.manage.service.table;

import hxc.manage.model.table.Patent;

import java.util.List;
import java.util.Map;

public interface PatentService {

    int insert(Patent pojo);

    int insertSelective(Patent pojo);

    int insertList(List<Patent> pojos);

    int update(Patent pojo);

    Patent getPatent(Map<String,Object> param);
}
