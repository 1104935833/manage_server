package hxc.manage.service;

import java.util.List;
import java.util.Map;

public interface GradeService {

    Map<String, Object> getGradeList(Integer start,Integer size);

    int editGrade(int id, int grade);

    Map<String, Object> getGradeListByTeacher(int start, int size, String name);

    Map<String, Object> getGradeListByOffice(int start, int size, String office);

    Map<String, Object> getGradeListByTeacherAndOffice(int start, int size, String name, String office);
}
