package hxc.manage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import hxc.manage.model.table.FirstSubject;

@Mapper
public interface FirstSubjectMapper {
    int insert(@Param("pojo") FirstSubject pojo);

    int insertSelective(@Param("pojo") FirstSubject pojo);

    int insertList(@Param("pojos") List<FirstSubject> pojo);

    int update(@Param("pojo") FirstSubject pojo);
}