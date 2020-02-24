package hxc.manage.service.table;

import hxc.manage.model.table.StudentResearch;

import java.util.List;

public interface StudentResearchService {

    int insert(StudentResearch pojo);

    int insertSelective(StudentResearch pojo);

    int insertList(List<StudentResearch> pojos);

    int update(StudentResearch pojo);
}
