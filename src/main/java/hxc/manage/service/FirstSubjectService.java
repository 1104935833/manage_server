package hxc.manage.service;

import hxc.manage.model.table.FirstSubject;

import java.util.List;
import java.util.Map;

public interface FirstSubjectService {

    int insert(FirstSubject pojo);

    int insertSelective(FirstSubject pojo);

    int insertList(List<FirstSubject> pojos);

    int update(FirstSubject pojo);

    List<Map<String,Object>> getFirstSubjects(Map param);
}
