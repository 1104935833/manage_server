package hxc.manage.controller.Table;

import hxc.manage.common.DateConverter;
import hxc.manage.common.JwtTokenProvider;
import hxc.manage.model.RespBean;
import hxc.manage.model.User;
import hxc.manage.model.table.FirstSubject;
import hxc.manage.service.AuditService;
import hxc.manage.service.PeddingService;
import hxc.manage.service.TableService;
import hxc.manage.service.table.FirstSubjectService;
import hxc.manage.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class FirstSubjectController {

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    FirstSubjectService firstSubjectService;

    @Autowired
    TableService tableService;

    @Autowired
    PeddingService peddingService;

    @Autowired
    AuditService auditService;

    @PostMapping("/insertFirstSubject")
    public RespBean insertFirstSubject(HttpServletRequest request, FirstSubject firstSubject) throws ParseException {
        DateConverter dateConverter = new DateConverter();
        String token = request.getHeader("Authorization");
        User u =jwtTokenProvider.getUserFromToken(token);
        firstSubject.setApprovalTime(dateConverter.date1ToTimeMillis(firstSubject.getApprovalTime()));
        firstSubject.setInceptTime(dateConverter.date1ToTimeMillis(firstSubject.getInceptTime()));
        firstSubject.setCreateTime(String.valueOf(new Date().getTime()));
        int id = tableService.table(request,u.getUser_id(),"jt_first_subject",17);
        firstSubject.setTableId(id);
        firstSubjectService.insert(firstSubject);

        return RespBean.ok("操作成功");
    }

    @PostMapping("/updataFirstSubject")
    public RespBean updataFirstSubject(HttpServletRequest request, @RequestBody Map info) throws ParseException {
        Map<String,Object> map = info;
        DateConverter dateConverter = new DateConverter();
        FirstSubject firstSubject = Util.mapToEntity((Map<String, Object>) map.get("firstSubject"),FirstSubject.class) ;
        String tableId = String.valueOf(info.get("tableId"));
        String id = String.valueOf(info.get("id"));
        firstSubject.setApprovalTime(dateConverter.date1ToTimeMillis(firstSubject.getApprovalTime()));
        firstSubject.setInceptTime(dateConverter.date1ToTimeMillis(firstSubject.getInceptTime()));
        firstSubjectService.update(firstSubject);
        peddingService.sendPedding(request,firstSubject.getTableId()+"","1","0","4");
        auditService.updateAuit(tableId,"0","0",id,request);
        return RespBean.ok("操作成功");
    }

    @GetMapping("/getFirstSubject")
    public Map<String,Object> getFirstSubject(@RequestParam(required = false) Map param){
        DateConverter dateConverter = new DateConverter();
        FirstSubject res = firstSubjectService.getFirstSubject(param);
        res.setApprovalTime(dateConverter.stampToDate(res.getApprovalTime()));
        res.setInceptTime(dateConverter.stampToDate(res.getInceptTime()));
        Map<String,Object> map = new HashMap<>();
        map.put("res",res);
        return map;
    }



}
