package hxc.manage.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface GradeMapper {

    List<Map<String, Object>> getGradeList(@Param("start") int page,@Param("size") int size);


    List<Map<String,Object>> getGradeListSize();

    int editGrade(@Param("id") int id, @Param("grade") int grade);

    List<Map<String, Object>> getGradeListByTeacher(@Param("start") int start, @Param("size") int size,@Param("name") String name);

    List<Map<String, Object>> getGradeListByOffice(@Param("start") int start, @Param("size") int size,@Param("office") String office);

    List<Map<String, Object>> getGradeListByTeacherAndOffice(@Param("start") int start, @Param("size") int size,@Param("name") String name,@Param("office") String office);




    int getGradeListByTeacherCount(@Param("start") int start, @Param("size") int size,@Param("name") String name);

    int getGradeListByOfficeCount(@Param("start") int start, @Param("size") int size,@Param("office") String office);

    int getGradeListByTeacherAndOfficeCount(@Param("start") int start, @Param("size") int size,@Param("name") String name,@Param("office") String office);
}
