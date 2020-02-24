package hxc.manage.controller.Table;

import hxc.manage.model.RespBean;
import hxc.manage.model.User;
import hxc.manage.model.table.StudentResearch;
import hxc.manage.service.AuditService;
import hxc.manage.service.PeddingService;
import hxc.manage.service.TableService;
import hxc.manage.service.table.StudentResearchService;
import hxc.manage.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentResearchController {

    @Autowired
    StudentResearchService studentResearchService;

    @Autowired
    TableService tableService;

    @Autowired
    PeddingService peddingService;

    @Autowired
    AuditService auditService;

    @PostMapping("/insertStudentResearchService")
    public RespBean insertStudentResearchService(HttpServletRequest request, StudentResearch studentResearch) throws ParseException {
        User u = (User) request.getSession().getAttribute("userinfo");
        studentResearch.setCreateTime(String.valueOf(new Date().getTime()));
        studentResearchService.insert(studentResearch);
        tableService.table(request,u.getUser_id(),String.valueOf(studentResearch.getId()),"jx_student_research",24);
        return RespBean.ok("操作成功");
    }

    @PostMapping("/updataStudentResearchService")
    public RespBean updataStudentResearchService(HttpServletRequest request, @RequestBody Map info) throws ParseException {
        Map<String,Object> map = info;
        StudentResearch studentResearch = Util.mapToEntity((Map<String, Object>) map.get("studentResearch"),StudentResearch.class) ;
        String tableId = String.valueOf(info.get("tableId"));
        String id = String.valueOf(info.get("id"));
        studentResearchService.update(studentResearch);
        peddingService.sendPedding(request,tableId,"1","0","4");
        auditService.updateAuit(tableId,"0","0",id,request);
        return RespBean.ok("操作成功");
    }

    @GetMapping("/getStudentResearchService")
    public Map<String,Object> getStudentResearchService(@RequestParam(required = false) Map param){
        StudentResearch res = studentResearchService.getStudentResearchService(param);
        Map<String,Object> map = new HashMap<>();
        map.put("res",res);
        return map;
    }
}
