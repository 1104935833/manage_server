package hxc.manage.service.table;

import hxc.manage.model.table.Technological;

import java.util.List;
import java.util.Map;

public interface TechnologicalService {

    int insert(Technological pojo);

    int insertSelective(Technological pojo);

    int insertList(List<Technological> pojos);

    int update(Technological pojo);

    Technological getTechnological(Map<String,Object> param);
}
