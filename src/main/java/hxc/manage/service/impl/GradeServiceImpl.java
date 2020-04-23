package hxc.manage.service.impl;

import com.fasterxml.jackson.core.json.async.NonBlockingJsonParser;
import com.sun.javaws.IconUtil;
import hxc.manage.mapper.GradeMapper;
import hxc.manage.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    GradeMapper gradeMapper;

    @Override
    public Map<String,Object> getGradeList(Integer start,Integer size){
        List<Map<String,Object>> list=  gradeMapper.getGradeList(start,size);
        Map<String,Object> map = new HashMap<>();
        map.put("data",list);
        map.put("total",gradeMapper.getGradeListSize().size());
        return map;
    }

    @Override
    public int editGrade(int id, int grade) {
        int res = gradeMapper.editGrade(id,grade);
        return res;
    }

    @Override
    public Map<String, Object> getGradeListByTeacher(int start, int size,String name) {
        List<Map<String,Object>> list=  gradeMapper.getGradeListByTeacher(start,size,name);
        int sum=0;
        for (Map<String, Object> map :
                list) {
            sum +=Integer.parseInt(map.get("grade").toString());
        }
        Map<String,Object> map = new HashMap<>();
        map.put("data",list);
        map.put("count",sum);
        map.put("total",gradeMapper.getGradeListByTeacherCount(start,size,name));
        return map;

    }

    @Override
    public Map<String, Object> getGradeListByOffice(int start, int size, String office) {
        List<Map<String,Object>> list=  gradeMapper.getGradeListByOffice(start,size,office);
        int sum=0;
        for (Map<String, Object> map :
                list) {
            sum +=Integer.parseInt(map.get("grade").toString());
        }
        Map<String,Object> map = new HashMap<>();
        map.put("data",list);
        map.put("count",sum);
        map.put("total",gradeMapper.getGradeListByOfficeCount(start,size,office));
        return map;
    }

    @Override
    public Map<String, Object> getGradeListByTeacherAndOffice(int start, int size, String name, String office) {
        List<Map<String,Object>> list=  gradeMapper.getGradeListByTeacherAndOffice(start,size,name,office);
        int sum=0;
        for (Map<String, Object> map :
                list) {
            sum +=Integer.parseInt(map.get("grade").toString());
        }
        Map<String,Object> map = new HashMap<>();
        map.put("data",list);
        map.put("count",sum);
        map.put("total",gradeMapper.getGradeListByTeacherAndOfficeCount(start,size,name,office));
        return map;
    }

}
