package hxc.manage.service;

import java.util.List;
import java.util.Map;

public interface TechnologicalService {

    int insert(hxc.manage.model.table.Technological pojo);

    int insertSelective(hxc.manage.model.table.Technological pojo);

    int insertList(List<hxc.manage.model.table.Technological> pojos);

    int update(hxc.manage.model.table.Technological pojo);

    List<Map<String,Object>> getTechnologicals(Map param);

}
