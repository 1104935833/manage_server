package hxc.manage.controller.Table;

import hxc.manage.common.DateConverter;
import hxc.manage.model.RespBean;
import hxc.manage.model.User;
import hxc.manage.model.table.Lab;
import hxc.manage.model.table.Paper;
import hxc.manage.service.AuditService;
import hxc.manage.service.PeddingService;
import hxc.manage.service.TableService;
import hxc.manage.service.table.LabService;
import hxc.manage.service.table.PaperService;
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
public class LabController {

    @Autowired
    LabService labService;

    @Autowired
    TableService tableService;

    @Autowired
    PeddingService peddingService;

    @Autowired
    AuditService auditService;

    @PostMapping("/insertLab")
    public RespBean insertLab(HttpServletRequest request, Lab lab) throws ParseException {
        DateConverter dateConverter = new DateConverter();
        User u = (User) request.getSession().getAttribute("userinfo");
        lab.setApprovalTime(dateConverter.date1ToTimeMillis(lab.getApprovalTime()));
        lab.setLabApprovalTime(dateConverter.date1ToTimeMillis(lab.getLabApprovalTime()));
        lab.setDeclareEndTime(dateConverter.date1ToTimeMillis(lab.getDeclareEndTime()));
        lab.setDeclareStartTime(dateConverter.date1ToTimeMillis(lab.getDeclareStartTime()));
        lab.setCreateTime(String.valueOf(new Date().getTime()));
        int id = tableService.table(request,u.getUser_id(),"jt_lab",18);
        lab.setTableId(id);
        labService.insert(lab);

        return RespBean.ok("操作成功");
    }

    @PostMapping("/updataLab")
    public RespBean updataLab(HttpServletRequest request, @RequestBody Map info) throws ParseException {
        Map<String,Object> map = info;
        DateConverter dateConverter = new DateConverter();
        Lab lab = Util.mapToEntity((Map<String, Object>) map.get("lab"),Lab.class) ;
        String tableId = String.valueOf(info.get("tableId"));
        String id = String.valueOf(info.get("id"));
        lab.setApprovalTime(dateConverter.date1ToTimeMillis(lab.getApprovalTime()));
        lab.setLabApprovalTime(dateConverter.date1ToTimeMillis(lab.getLabApprovalTime()));
        lab.setDeclareEndTime(dateConverter.date1ToTimeMillis(lab.getDeclareEndTime()));
        lab.setDeclareStartTime(dateConverter.date1ToTimeMillis(lab.getDeclareStartTime()));
        labService.update(lab);
        peddingService.sendPedding(request,tableId,"1","0","4");
        auditService.updateAuit(tableId,"0","0",id,request);
        return RespBean.ok("操作成功");
    }

    @GetMapping("/getLab")
    public Map<String,Object> getLab(@RequestParam(required = false) Map param){
        DateConverter dateConverter = new DateConverter();
        Lab res = labService.getLab(param);
        res.setApprovalTime(dateConverter.stampToDate(res.getApprovalTime()));
        res.setLabApprovalTime(dateConverter.stampToDate(res.getLabApprovalTime()));
        res.setDeclareEndTime(dateConverter.stampToDate(res.getDeclareEndTime()));
        res.setDeclareStartTime(dateConverter.stampToDate(res.getDeclareStartTime()));
        Map<String,Object> map = new HashMap<>();
        map.put("res",res);
        return map;
    }

}
