package hxc.manage.controller.Table;

import hxc.manage.common.DateConverter;
import hxc.manage.common.JwtTokenProvider;
import hxc.manage.model.RespBean;
import hxc.manage.model.User;
import hxc.manage.model.table.Educational;
import hxc.manage.service.AuditService;
import hxc.manage.service.PeddingService;
import hxc.manage.service.TableService;
import hxc.manage.service.table.EducationalService;
import hxc.manage.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class EducationalController {

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    EducationalService educationalService;

    @Autowired
    TableService tableService;

    @Autowired
    PeddingService peddingService;

    @Autowired
    AuditService auditService;

    @PostMapping("/insertEducational")
    public RespBean insertEducational(HttpServletRequest request, Educational educational) throws ParseException {
        DateConverter dateConverter = new DateConverter();
        String token = request.getHeader("Authorization");
        User u =jwtTokenProvider.getUserFromToken(token);
        educational.setDeclareTime(dateConverter.date1ToTimeMillis(educational.getDeclareTime()));
        educational.setCreateTime(String.valueOf(new Date().getTime()));
        int id = tableService.table(request,u.getUser_id(),"jx_educational_reform",27);
        educational.setTableId(id);
        educationalService.insert(educational);

        return RespBean.ok("操作成功");
    }

    @PostMapping("/updataEducational")
    public RespBean updataEducational(HttpServletRequest request, @RequestBody Map info) throws ParseException {
        Map<String,Object> map = info;
        DateConverter dateConverter = new DateConverter();
        Educational educational = Util.mapToEntity((Map<String, Object>) map.get("educational"),Educational.class) ;
        String tableId = String.valueOf(info.get("tableId"));
        String id = String.valueOf(info.get("id"));
        educational.setDeclareTime(dateConverter.date1ToTimeMillis(educational.getDeclareTime()));
        educationalService.update(educational);
        peddingService.sendPedding(request,educational.getTableId()+"","1","0","4");
        auditService.updateAuit(tableId,"0","0",id,request);
        return RespBean.ok("操作成功");
    }

    @GetMapping("/getEducational")
    public Map<String,Object> getEducational(@RequestParam(required = false) Map param){
        DateConverter dateConverter = new DateConverter();
        Educational res = educationalService.getEducational(param);
        res.setDeclareTime(dateConverter.stampToDate(res.getDeclareTime()));
        Map<String,Object> map = new HashMap<>();
        map.put("res",res);
        return map;
    }
}

