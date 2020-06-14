package hxc.manage.controller.Table;

import hxc.manage.common.DateConverter;
import hxc.manage.common.JwtTokenProvider;
import hxc.manage.model.RespBean;
import hxc.manage.model.User;
import hxc.manage.model.table.Technological;
import hxc.manage.model.table.Technological;
import hxc.manage.service.AuditService;
import hxc.manage.service.PeddingService;
import hxc.manage.service.TableService;
import hxc.manage.service.table.TechnologicalService;
import hxc.manage.service.table.TechnologicalService;
import hxc.manage.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TechnologicalController {

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    TechnologicalService technologicalService;

    @Autowired
    TableService tableService;

    @Autowired
    PeddingService peddingService;

    @Autowired
    AuditService auditService;

    @PostMapping("/insertTechnological")
    public RespBean insertTechnological(HttpServletRequest request, Technological technological) throws ParseException {
        DateConverter dateConverter = new DateConverter();
        String token = request.getHeader("Authorization");
        User u =jwtTokenProvider.getUserFromToken(token);
        technological.setDeclareTime(dateConverter.date1ToTimeMillis(technological.getDeclareTime()));
        technological.setApprovalTime(dateConverter.date1ToTimeMillis(technological.getApprovalTime()));
        technological.setCreateTime(String.valueOf(new Date().getTime()));
        int id = tableService.table(request,u.getUser_id(),"jt_technological_innovation",19);
        technological.setTableId(id);
        technologicalService.insert(technological);
        return RespBean.ok("操作成功");
    }

    @PostMapping("/updataTechnological")
    public RespBean updataTechnological(HttpServletRequest request, @RequestBody Map info) throws ParseException {
        Map<String,Object> map = info;
        DateConverter dateConverter = new DateConverter();
        Technological technological = Util.mapToEntity((Map<String, Object>) map.get("technological"),Technological.class) ;
        String tableId = String.valueOf(info.get("tableId"));
        String id = String.valueOf(info.get("id"));
        technological.setDeclareTime(dateConverter.date1ToTimeMillis(technological.getDeclareTime()));
        technological.setApprovalTime(dateConverter.date1ToTimeMillis(technological.getApprovalTime()));
        technologicalService.update(technological);
        peddingService.sendPedding(request,technological.getTableId()+"","1","0","4");
        auditService.updateAuit(tableId,"0","0",id,request);
        return RespBean.ok("操作成功");
    }

    @GetMapping("/getTechnological")
    public Map<String,Object> getTechnological(@RequestParam(required = false) Map param){
        DateConverter dateConverter = new DateConverter();
        Technological res = technologicalService.getTechnological(param);
        res.setDeclareTime(dateConverter.stampToDate(res.getDeclareTime()));
        res.setApprovalTime(dateConverter.stampToDate(res.getApprovalTime()));
        Map<String,Object> map = new HashMap<>();
        map.put("res",res);
        return map;
    }





}
