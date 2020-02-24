package hxc.manage.service.table;

import hxc.manage.model.table.Academic;

import java.util.List;
import java.util.Map;

public interface AcademicService {

    int insert(Academic pojo);

    int insertSelective(Academic pojo);

    int insertList(List<Academic> pojos);

    int update(Academic pojo);

    Academic getAcademic(Map<String,Object> param);
}
