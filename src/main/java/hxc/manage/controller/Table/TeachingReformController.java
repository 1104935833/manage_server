package hxc.manage.controller.Table;

import hxc.manage.common.JwtTokenProvider;
import hxc.manage.model.RespBean;
import hxc.manage.model.User;
import hxc.manage.model.table.TeachingReform;
import hxc.manage.service.AuditService;
import hxc.manage.service.PeddingService;
import hxc.manage.service.TableService;
import hxc.manage.service.table.TeachingReformService;
import hxc.manage.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TeachingReformController {

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    TeachingReformService teachingReformService;

    @Autowired
    TableService tableService;

    @Autowired
    PeddingService peddingService;

    @Autowired
    AuditService auditService;

    @PostMapping("/insertTeachingReform")
    public RespBean insertTeachingReform(HttpServletRequest request,@RequestBody TeachingReform teachingReform) throws ParseException {
        String token = request.getHeader("Authorization");
        User u =jwtTokenProvider.getUserFromToken(token);
        teachingReform.setCreateTime(String.valueOf(new Date().getTime()));
        int id = tableService.table(request,u.getUser_id(),"jx_teaching_reform",29);
        teachingReform.setTableId(id);
        teachingReformService.insert(teachingReform);

        return RespBean.ok("操作成功");
    }

    @PostMapping("/updataTeachingReform")
    public RespBean updataTeachingReform(HttpServletRequest request, @RequestBody Map info) throws ParseException {
        String token = request.getHeader("Authorization");
        User user = jwtTokenProvider.getUserFromToken(token);
        Map<String,Object> map = info;
        TeachingReform teachingReform = Util.mapToEntity((Map<String, Object>) map.get("teachingReform"),TeachingReform.class) ;
        String tableId = String.valueOf(info.get("tableId"));
        String id = String.valueOf(info.get("id"));
        teachingReformService.update(teachingReform);
        peddingService.sendPedding(request,teachingReform.getTableId()+"","1","0","4");
        auditService.updateAuit(tableId,"0","0",id,user);
        return RespBean.ok("操作成功");
    }

    @GetMapping("/getTeachingReform")
    public RespBean getTeachingReform(@RequestParam(required = false) Map param){
        TeachingReform res = teachingReformService.getTeachingReform(param);
        Map<String,Object> map = new HashMap<>();
        map.put("res",res);
        return RespBean.ok("操作成功",map);
    }


}
