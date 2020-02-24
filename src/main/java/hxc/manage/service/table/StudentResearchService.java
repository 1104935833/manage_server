package hxc.manage.service.table;

import hxc.manage.model.table.StudentResearch;

import java.util.List;
import java.util.Map;

public interface StudentResearchService {

    int insert(StudentResearch pojo);

    int insertSelective(StudentResearch pojo);

    int insertList(List<StudentResearch> pojos);

    int update(StudentResearch pojo);

    StudentResearch getStudentResearchService(Map<String,Object> param);
}
