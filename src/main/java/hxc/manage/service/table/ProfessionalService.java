package hxc.manage.service.table;

import hxc.manage.model.table.Professional;

import java.util.List;
import java.util.Map;

public interface ProfessionalService {

    int insert(Professional pojo);

    int insertSelective(Professional pojo);

    int insertList(List<Professional> pojos);

    int update(Professional pojo);

    Professional getProfessional(Map<String,Object> param);
}
