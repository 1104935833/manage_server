package hxc.manage.service.table;

import hxc.manage.model.table.Lab;

import java.util.List;
import java.util.Map;

public interface LabService {

    int insert(Lab pojo);

    int insertSelective(Lab pojo);

    int insertList(List<Lab> pojos);

    int update(Lab pojo);

    Lab getLab(Map<String,Object> param);
}
