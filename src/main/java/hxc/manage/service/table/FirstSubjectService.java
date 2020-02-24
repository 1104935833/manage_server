package hxc.manage.service.table;

import hxc.manage.model.table.FirstSubject;

import java.util.List;
import java.util.Map;

public interface FirstSubjectService {

    int insert(FirstSubject pojo);

    int insertSelective(FirstSubject pojo);

    int insertList(List<FirstSubject> pojos);

    int update(FirstSubject pojo);

    FirstSubject getFirstSubject(Map<String,Object> param);
}
