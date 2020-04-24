package hxc.manage.controller;

import com.alibaba.druid.util.StringUtils;
import hxc.manage.model.RespBean;
import hxc.manage.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/grade")
public class GradeController {

    @Autowired
    GradeService gradeService;

    @GetMapping("/getGradeList")
    public RespBean getGradeList(@RequestParam("size") int size,@RequestParam("page") int page){
        int start = (page - 1) * size;
        Map<String,Object> gradeList = gradeService.getGradeList(start,size);
        return RespBean.ok("",gradeList);
    }

    @GetMapping("/getGradeListByTeacher")
    public RespBean getGradeListByTeacher(@RequestParam("size") int size,@RequestParam("page") int page,@RequestParam(defaultValue = "") String name,@RequestParam(defaultValue = "") String office){
        int start = (page - 1) * size;
        Map<String,Object> gradeList;
        if (!StringUtils.equals("",office)){
            gradeList= gradeService.getGradeListByOffice(start,size,office);
        }else if(!StringUtils.equals("",name)){
            gradeList = gradeService.getGradeListByTeacher(start,size,name);
        }else{
            gradeList = gradeService.getGradeListByTeacherAndOffice(start,size,name,office);
        }
        return RespBean.ok("",gradeList);
    }



    @PutMapping("/editGrade")
    public RespBean editGrade(@RequestParam("id") int id,@RequestParam("grade") int grade){
        try {
            gradeService.editGrade(id, grade);
            return RespBean.ok("");
        }catch (Exception e){
            return RespBean.error("");
        }
    }




}
