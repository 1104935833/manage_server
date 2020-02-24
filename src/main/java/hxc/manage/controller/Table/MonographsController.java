package hxc.manage.controller.Table;

import hxc.manage.common.DateConverter;
import hxc.manage.model.RespBean;
import hxc.manage.model.User;
import hxc.manage.model.table.Monographs;
import hxc.manage.model.table.Monographs;
import hxc.manage.service.AuditService;
import hxc.manage.service.PeddingService;
import hxc.manage.service.TableService;
import hxc.manage.service.table.MonographsService;
import hxc.manage.service.table.MonographsService;
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
public class MonographsController {


    @Autowired
    MonographsService monographsService;

    @Autowired
    TableService tableService;

    @Autowired
    PeddingService peddingService;

    @Autowired
    AuditService auditService;

    @PostMapping("/insertMonographs")
    public RespBean insertMonographs(HttpServletRequest request, Monographs monographs) throws ParseException {
        DateConverter dateConverter = new DateConverter();
        User u = (User) request.getSession().getAttribute("userinfo");
        monographs.setFinishTime(dateConverter.date1ToTimeMillis(monographs.getFinishTime()));
        monographs.setCreateTime(String.valueOf(new Date().getTime()));
        monographsService.insert(monographs);
        tableService.table(request,u.getUser_id(),String.valueOf(monographs.getId()),"tb_Monographs",8);
        return RespBean.ok("操作成功");
    }

    @PostMapping("/updataMonographs")
    public RespBean updataMonographs(HttpServletRequest request, @RequestBody Map info) throws ParseException {
        Map<String,Object> map = info;
        DateConverter dateConverter = new DateConverter();
        Monographs monographs = Util.mapToEntity((Map<String, Object>) map.get("monographs"),Monographs.class) ;
        String tableId = String.valueOf(info.get("tableId"));
        String id = String.valueOf(info.get("id"));
        monographs.setFinishTime(dateConverter.date1ToTimeMillis(monographs.getFinishTime()));
        monographsService.update(monographs);
        peddingService.sendPedding(request,tableId,"1","0","4");
        auditService.updateAuit(tableId,"0","0",id,request);
        return RespBean.ok("操作成功");
    }

    @GetMapping("/getMonographs")
    public Map<String,Object> getMonographs(@RequestParam(required = false) Map param){
        DateConverter dateConverter = new DateConverter();
        Monographs res = monographsService.getMonographs(param);
        res.setFinishTime(dateConverter.stampToDate(res.getFinishTime()));
        Map<String,Object> map = new HashMap<>();
        map.put("res",res);
        return map;
    }


}
