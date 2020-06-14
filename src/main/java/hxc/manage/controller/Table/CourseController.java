package hxc.manage.controller.Table;

import hxc.manage.common.DateConverter;
import hxc.manage.common.JwtTokenProvider;
import hxc.manage.model.RespBean;
import hxc.manage.model.User;
import hxc.manage.model.table.Course;
import hxc.manage.service.AuditService;
import hxc.manage.service.PeddingService;
import hxc.manage.service.TableService;
import hxc.manage.service.table.CourseService;
import hxc.manage.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CourseController {

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    CourseService courseService;

    @Autowired
    TableService tableService;

    @Autowired
    PeddingService peddingService;

    @Autowired
    AuditService auditService;

    @PostMapping("/insertCourse")
    public RespBean insertCourse(HttpServletRequest request, Course course) throws ParseException {
        DateConverter dateConverter = new DateConverter();
        String token = request.getHeader("Authorization");
        User u =jwtTokenProvider.getUserFromToken(token);
        course.setDeclareTime(dateConverter.date1ToTimeMillis(course.getDeclareTime()));
        course.setCreateTime(String.valueOf(new Date().getTime()));
        int id = tableService.table(request,u.getUser_id(),"jx_course_construction",30);
        course.setTableId(id);
        courseService.insert(course);
        return RespBean.ok("操作成功");
    }

    @PostMapping("/updataCourse")
    public RespBean updataCourse(HttpServletRequest request, @RequestBody Map info) throws ParseException {
        Map<String,Object> map = info;
        DateConverter dateConverter = new DateConverter();
        Course course = Util.mapToEntity((Map<String, Object>) map.get("course"),Course.class) ;
        String tableId = String.valueOf(info.get("tableId"));
        String id = String.valueOf(info.get("id"));
        course.setDeclareTime(dateConverter.date1ToTimeMillis(course.getDeclareTime()));
        courseService.update(course);
        peddingService.sendPedding(request,course.getTableId()+"","1","0","4");
        auditService.updateAuit(tableId,"0","0",id,request);
        return RespBean.ok("操作成功");
    }

    @GetMapping("/getCourse")
    public Map<String,Object> getCourse(@RequestParam(required = false) Map param){
        DateConverter dateConverter = new DateConverter();
        Course res = courseService.getCourse(param);
        res.setDeclareTime(dateConverter.stampToDate(res.getDeclareTime()));
        Map<String,Object> map = new HashMap<>();
        map.put("res",res);
        return map;
    }


}
