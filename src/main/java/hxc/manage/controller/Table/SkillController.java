package hxc.manage.controller.Table;

import hxc.manage.common.JwtTokenProvider;
import hxc.manage.model.RespBean;
import hxc.manage.model.User;
import hxc.manage.model.table.Skill;
import hxc.manage.service.AuditService;
import hxc.manage.service.PeddingService;
import hxc.manage.service.TableService;
import hxc.manage.service.table.SkillService;
import hxc.manage.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class SkillController {

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    SkillService skillService;

    @Autowired
    TableService tableService;

    @Autowired
    PeddingService peddingService;

    @Autowired
    AuditService auditService;

    @PostMapping("/insertSkill")
    public RespBean insertSkill(HttpServletRequest request, Skill skill) throws ParseException {
        String token = request.getHeader("Authorization");
        User u =jwtTokenProvider.getUserFromToken(token);
        skill.setCreateTime(String.valueOf(new Date().getTime()));
        int id = tableService.table(request,u.getUser_id(),"jx_skill_competition",25);
        skill.setTableId(id);
        skillService.insert(skill);

        return RespBean.ok("操作成功");
    }

    @PostMapping("/updataSkill")
    public RespBean updataSkill(HttpServletRequest request, @RequestBody Map info) throws ParseException {
        Map<String,Object> map = info;
        Skill skill = Util.mapToEntity((Map<String, Object>) map.get("skill"), Skill.class) ;
        String tableId = String.valueOf(info.get("tableId"));
        String id = String.valueOf(info.get("id"));
        skillService.update(skill);
        peddingService.sendPedding(request,skill.getTableId()+"","1","0","4");
        auditService.updateAuit(tableId,"0","0",id,request);
        return RespBean.ok("操作成功");
    }

    @GetMapping("/getSkill")
    public Map<String,Object> getSkill(@RequestParam(required = false) Map param){
        Skill res = skillService.getSkill(param);
        Map<String,Object> map = new HashMap<>();
        map.put("res",res);
        return map;
    }

}
