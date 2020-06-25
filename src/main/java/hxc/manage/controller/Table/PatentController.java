package hxc.manage.controller.Table;

import hxc.manage.common.JwtTokenProvider;
import hxc.manage.model.RespBean;
import hxc.manage.model.User;
import hxc.manage.model.table.Patent;
import hxc.manage.service.AuditService;
import hxc.manage.service.PeddingService;
import hxc.manage.service.TableService;
import hxc.manage.service.table.PatentService;
import hxc.manage.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class PatentController {

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    PatentService patentService;

    @Autowired
    TableService tableService;

    @Autowired
    PeddingService peddingService;

    @Autowired
    AuditService auditService;

    @PostMapping("/insertPatent")
    public RespBean insertPatent(HttpServletRequest request,@RequestBody Patent patent) throws ParseException {
        String token = request.getHeader("Authorization");
        User u =jwtTokenProvider.getUserFromToken(token);
        patent.setCreateTime(String.valueOf(new Date().getTime()));
        int id = tableService.table(request,u.getUser_id(),"tb_patent",9);
        patent.setTableId(id);
        patentService.insert(patent);

        return RespBean.ok("操作成功");
    }

    @PostMapping("/updataPatent")
    public RespBean updataPatent(HttpServletRequest request, @RequestBody Map info) throws ParseException {
        Map<String,Object> map = info;
        Patent patent = Util.mapToEntity((Map<String, Object>) map.get("patent"),Patent.class) ;
        String tableId = String.valueOf(info.get("tableId"));
        String id = String.valueOf(info.get("id"));
        patentService.update(patent);
        peddingService.sendPedding(request,patent.getTableId()+"","1","0","4");
        auditService.updateAuit(tableId,"0","0",id,request);
        return RespBean.ok("操作成功");
    }

    @GetMapping("/getPatent")
    public RespBean getPatent(@RequestParam(required = false) Map param){
        Patent res = patentService.getPatent(param);
        Map<String,Object> map = new HashMap<>();
        map.put("res",res);
        return RespBean.ok("操作成功",map);
    }



}
