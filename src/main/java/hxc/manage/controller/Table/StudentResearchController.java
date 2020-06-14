package hxc.manage.controller.Table;

import hxc.manage.common.JwtTokenProvider;
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
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    StudentResearchService studentResearchService;

    @Autowired
    TableService tableService;

    @Autowired
    PeddingService peddingService;

    @Autowired
    AuditService auditService;

    @PostMapping("/insertStudentResearch")
    public RespBean insertStudentResearchService(HttpServletRequest request, StudentResearch studentResearch) throws ParseException {
        String token = request.getHeader("Authorization");
        User u =jwtTokenProvider.getUserFromToken(token);
        studentResearch.setCreateTime(String.valueOf(new Date().getTime()));
        int id = tableService.table(request,u.getUser_id(),"jx_student_research",24);
        studentResearch.setTableId(id);
        studentResearchService.insert(studentResearch);

        return RespBean.ok("操作成功");
    }

    @PostMapping("/updataStudentResearch")
    public RespBean updataStudentResearchService(HttpServletRequest request, @RequestBody Map info) throws ParseException {
        Map<String,Object> map = info;
        StudentResearch studentResearch = Util.mapToEntity((Map<String, Object>) map.get("studentResearch"),StudentResearch.class) ;
        String tableId = String.valueOf(info.get("tableId"));
        String id = String.valueOf(info.get("id"));
        studentResearchService.update(studentResearch);
        peddingService.sendPedding(request,studentResearch.getTableId()+"","1","0","4");
        auditService.updateAuit(tableId,"0","0",id,request);
        return RespBean.ok("操作成功");
    }

    @GetMapping("/getStudentResearch")
    public Map<String,Object> getStudentResearchService(@RequestParam(required = false) Map param){
        StudentResearch res = studentResearchService.getStudentResearchService(param);
        Map<String,Object> map = new HashMap<>();
        map.put("res",res);
        return map;
    }
}
