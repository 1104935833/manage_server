package hxc.manage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

import hxc.manage.model.table.StudentResearch;

@Mapper
public interface StudentResearchMapper {
    int insert(@Param("pojo") StudentResearch pojo);

    int insertSelective(@Param("pojo") StudentResearch pojo);

    int insertList(@Param("pojos") List<StudentResearch> pojo);

    int update(@Param("pojo") StudentResearch pojo);

    StudentResearch getStudentResearchService(@Param("pojo") Map<String, Object> param);
}
