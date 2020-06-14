package hxc.manage.controller.Table;

import hxc.manage.common.DateConverter;
import hxc.manage.common.JwtTokenProvider;
import hxc.manage.model.RespBean;
import hxc.manage.model.User;
import hxc.manage.model.table.Academic;
import hxc.manage.service.AuditService;
import hxc.manage.service.PeddingService;
import hxc.manage.service.TableService;
import hxc.manage.service.table.AcademicService;
import hxc.manage.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AcademicController {

    @Autowired
    AcademicService academicService;

    @Autowired
    TableService tableService;

    @Autowired
    PeddingService peddingService;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    AuditService auditService;

    @PostMapping("/insertAcademic")
    public RespBean insertAcademic(HttpServletRequest request, Academic academic) throws ParseException {
        DateConverter dateConverter = new DateConverter();
        String token = request.getHeader("Authorization");
        User u =jwtTokenProvider.getUserFromToken(token);
        academic.setCreateTime(String.valueOf(new Date().getTime()));
        academic.setDeclareTime(dateConverter.date1ToTimeMillis(academic.getDeclareTime()));
        int id = tableService.table(request,u.getUser_id(),"jt_academic_innovation",21);
        academic.setTableId(id);
        academicService.insert(academic);

        return RespBean.ok("操作成功");
    }

    @PostMapping("/updataAcademic")
    public RespBean updataAcademic(HttpServletRequest request, @RequestBody Map info) throws ParseException {
        DateConverter dateConverter = new DateConverter();
        Map<String,Object> map = info;
        Academic academic = Util.mapToEntity((Map<String, Object>) map.get("academic"),Academic.class) ;
        String tableId = String.valueOf(info.get("tableId"));
        String id = String.valueOf(info.get("id"));
        academic.setDeclareTime(dateConverter.date1ToTimeMillis(academic.getDeclareTime()));
        academicService.update(academic);
        peddingService.sendPedding(request,academic.getTableId()+"","1","0","4");
        auditService.updateAuit(tableId,"0","0",id,request);
        return RespBean.ok("操作成功");
    }

    @GetMapping("/getAcademic")
    public Map<String,Object> getAcademic(@RequestParam(required = false) Map param){
        DateConverter dateConverter = new DateConverter();
        Academic res = academicService.getAcademic(param);
        res.setDeclareTime(dateConverter.stampToDate(res.getDeclareTime()));
        Map<String,Object> map = new HashMap<>();
        map.put("res",res);
        return map;
    }

}
