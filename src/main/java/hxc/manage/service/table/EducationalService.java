package hxc.manage.service.table;

import hxc.manage.model.table.Educational;

import java.util.List;

public interface EducationalService {

    int insert(Educational pojo);

    int insertSelective(Educational pojo);

    int insertList(List<Educational> pojos);

    int update(Educational pojo);
}
