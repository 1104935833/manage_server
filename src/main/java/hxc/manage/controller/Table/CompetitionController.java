package hxc.manage.controller.Table;

import hxc.manage.common.DateConverter;
import hxc.manage.common.JwtTokenProvider;
import hxc.manage.model.RespBean;
import hxc.manage.model.User;
import hxc.manage.model.table.Competition;
import hxc.manage.model.table.Paper;
import hxc.manage.service.AuditService;
import hxc.manage.service.PeddingService;
import hxc.manage.service.TableService;
import hxc.manage.service.table.CompetitionService;
import hxc.manage.service.table.PaperService;
import hxc.manage.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CompetitionController {

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    CompetitionService competitionService;

    @Autowired
    TableService tableService;

    @Autowired
    PeddingService peddingService;

    @Autowired
    AuditService auditService;

    @PostMapping("/insertCompetition")
    public RespBean insertCompetition(HttpServletRequest request,@RequestBody Competition competition) throws ParseException {
        DateConverter dateConverter = new DateConverter();
        String token = request.getHeader("Authorization");
        User u =jwtTokenProvider.getUserFromToken(token);
        competition.setApprovalTime(dateConverter.date1ToTimeMillis(competition.getApprovalTime()));
        competition.setCreateTime(String.valueOf(new Date().getTime()));

        int id = tableService.table(request,u.getUser_id(),"jx_competition_direct",26);
        competition.setTableId(id);
        competitionService.insert(competition);
        return RespBean.ok("操作成功");
    }

    @PostMapping("/updataCompetition")
    public RespBean updataCompetition(HttpServletRequest request, @RequestBody Map info) throws ParseException {
        String token = request.getHeader("Authorization");
        User user = jwtTokenProvider.getUserFromToken(token);
        Map<String,Object> map = info;
        DateConverter dateConverter = new DateConverter();
        Competition competition = Util.mapToEntity((Map<String, Object>) map.get("competition"),Competition.class) ;
        String tableId = String.valueOf(info.get("tableId"));
        String id = String.valueOf(info.get("id"));
        competition.setApprovalTime(dateConverter.date1ToTimeMillis(competition.getApprovalTime()));
        competitionService.update(competition);
        peddingService.sendPedding(request,competition.getTableId()+"","1","0","4");
        auditService.updateAuit(tableId,"0","0",id,user);
        return RespBean.ok("操作成功");
    }

    @GetMapping("/getCompetition")
    public RespBean getCompetition(@RequestParam(required = false) Map param){
        DateConverter dateConverter = new DateConverter();
        Competition res = competitionService.getCompetition(param);
        res.setApprovalTime(dateConverter.stampToDate(res.getApprovalTime()));
        Map<String,Object> map = new HashMap<>();
        map.put("res",res);
        return RespBean.ok("操作成功",map);

    }


}
