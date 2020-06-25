package hxc.manage.controller.Table;

import hxc.manage.common.DateConverter;
import hxc.manage.common.JwtTokenProvider;
import hxc.manage.model.RespBean;
import hxc.manage.model.User;
import hxc.manage.model.table.Portrait;
import hxc.manage.model.table.Portrait;
import hxc.manage.service.AuditService;
import hxc.manage.service.PeddingService;
import hxc.manage.service.TableService;
import hxc.manage.service.table.PortraitService;
import hxc.manage.service.table.PortraitService;
import hxc.manage.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class PortraitController {

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    PortraitService portraitService;

    @Autowired
    TableService tableService;

    @Autowired
    PeddingService peddingService;

    @Autowired
    AuditService auditService;

    @PostMapping("/insertPortrait")
    public RespBean insertPortrait(HttpServletRequest request,@RequestBody Portrait portrait) throws ParseException {
        String token = request.getHeader("Authorization");
        User u =jwtTokenProvider.getUserFromToken(token);
        portrait.setCreateTime(String.valueOf(new Date().getTime()));
        int id = tableService.table(request,u.getUser_id(),"tb_portrait",10);
        portrait.setTableId(id);
        portraitService.insert(portrait);

        return RespBean.ok("操作成功");
    }

    @PostMapping("/updataPortrait")
    public RespBean updataPortrait(HttpServletRequest request, @RequestBody Map info) throws ParseException {
        Map<String,Object> map = info;
        Portrait portrait = Util.mapToEntity((Map<String, Object>) map.get("portrait"),Portrait.class) ;
        String tableId = String.valueOf(info.get("tableId"));
        String id = String.valueOf(info.get("id"));
        portraitService.update(portrait);
        peddingService.sendPedding(request,portrait.getTitle()+"","1","0","4");
        auditService.updateAuit(tableId,"0","0",id,request);
        return RespBean.ok("操作成功");
    }

    @GetMapping("/getPortrait")
    public RespBean getPortrait(@RequestParam(required = false) Map param){
        Portrait res = portraitService.getPortrait(param);
        Map<String,Object> map = new HashMap<>();
        map.put("res",res);
        return RespBean.ok("操作成功",map);
    }



}
