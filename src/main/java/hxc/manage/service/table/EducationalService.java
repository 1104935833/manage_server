package hxc.manage.service.table;

import hxc.manage.model.table.Educational;

import java.util.List;
import java.util.Map;

public interface EducationalService {

    int insert(Educational pojo);

    int insertSelective(Educational pojo);

    int insertList(List<Educational> pojos);

    int update(Educational pojo);

    Educational getEducational(Map<String,Object> param);
}
