package hxc.manage.controller.Table;

import hxc.manage.common.DateConverter;
import hxc.manage.common.JwtTokenProvider;
import hxc.manage.model.RespBean;
import hxc.manage.model.User;
import hxc.manage.model.table.Transverse;
import hxc.manage.model.table.Transverse;
import hxc.manage.service.AuditService;
import hxc.manage.service.PeddingService;
import hxc.manage.service.TableService;
import hxc.manage.service.table.TransverseService;
import hxc.manage.service.table.TransverseService;
import hxc.manage.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TransverseController {

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    TransverseService transverseService;

    @Autowired
    TableService tableService;

    @Autowired
    PeddingService peddingService;

    @Autowired
    AuditService auditService;

    @PostMapping("/insertTransverse")
    public RespBean insertTransverse(HttpServletRequest request, Transverse transverse) throws ParseException {
        DateConverter dateConverter = new DateConverter();
        String token = request.getHeader("Authorization");
        User u =jwtTokenProvider.getUserFromToken(token);
        transverse.setStartTime(dateConverter.date1ToTimeMillis(transverse.getStartTime()));
        transverse.setCreateTime(String.valueOf(new Date().getTime()));
        int id = tableService.table(request,u.getUser_id(),"tb_transverse",11);
        transverse.setTableId(id);
        transverseService.insert(transverse);
        return RespBean.ok("操作成功");
    }

    @PostMapping("/updataTransverse")
    public RespBean updataTransverse(HttpServletRequest request, @RequestBody Map info) throws ParseException {
        Map<String,Object> map = info;
        DateConverter dateConverter = new DateConverter();
        Transverse transverse = Util.mapToEntity((Map<String, Object>) map.get("transverse"),Transverse.class) ;
        String tableId = String.valueOf(info.get("tableId"));
        String id = String.valueOf(info.get("id"));
        transverse.setStartTime(dateConverter.date1ToTimeMillis(transverse.getStartTime()));
        transverseService.update(transverse);
        peddingService.sendPedding(request,transverse.getTableId()+"","1","0","4");
        auditService.updateAuit(tableId,"0","0",id,request);
        return RespBean.ok("操作成功");
    }

    @GetMapping("/getTransverse")
    public Map<String,Object> getTransverse(@RequestParam(required = false) Map param){
        DateConverter dateConverter = new DateConverter();
        Transverse res = transverseService.getTransverse(param);
        res.setStartTime(dateConverter.stampToDate(res.getStartTime()));
        Map<String,Object> map = new HashMap<>();
        map.put("res",res);
        return map;
    }








}
