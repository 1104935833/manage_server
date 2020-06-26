package hxc.manage.controller.Table;

import hxc.manage.common.DateConverter;
import hxc.manage.common.JwtTokenProvider;
import hxc.manage.model.RespBean;
import hxc.manage.model.User;
import hxc.manage.model.table.Achievement;
import hxc.manage.service.AuditService;
import hxc.manage.service.PeddingService;
import hxc.manage.service.TableService;
import hxc.manage.service.table.AchievementService;
import hxc.manage.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AchievementController {

    @Autowired
    AchievementService achievementService;

    @Autowired
    TableService tableService;

    @Autowired
    PeddingService peddingService;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    AuditService auditService;

    @PostMapping("/insertAchievement")
    public RespBean insertAchievement(HttpServletRequest request,@RequestBody Achievement achievement) throws ParseException {
        DateConverter dateConverter = new DateConverter();
        String token = request.getHeader("Authorization");
        User u = jwtTokenProvider.getUserFromToken(token);
        achievement.setApplyTime(dateConverter.date1ToTimeMillis(achievement.getApplyTime()));
        achievement.setCreateTime(String.valueOf(new Date().getTime()));
        int id = tableService.table(request, u.getUser_id(), "jx_achievement_prize", 28);
        achievement.setTableId(id);
        achievementService.insert(achievement);
        return RespBean.ok("操作成功");
    }

    @PostMapping("/updataAchievement")
    public RespBean updataAchievement(HttpServletRequest request, @RequestBody Map info) throws ParseException {
        String token = request.getHeader("Authorization");
        User user = jwtTokenProvider.getUserFromToken(token);
        Map<String, Object> map = info;
        DateConverter dateConverter = new DateConverter();
        Achievement achievement = Util.mapToEntity((Map<String, Object>) map.get("achievement"), Achievement.class);
        String tableId = String.valueOf(info.get("tableId"));
        String id = String.valueOf(info.get("id"));
        achievement.setApplyTime(dateConverter.date1ToTimeMillis(achievement.getApplyTime()));
        achievementService.update(achievement);
        peddingService.sendPedding(request, achievement.getTableId() + "", "1", "0", "4");
        auditService.updateAuit(tableId, "0", "0", id, user);
        return RespBean.ok("操作成功");
    }

    @GetMapping("/getAchievement")
    public RespBean getAchievement(@RequestParam(required = false) Map param) {
        DateConverter dateConverter = new DateConverter();
        Achievement achievement = achievementService.getAchievement(param);
        achievement.setApplyTime(dateConverter.stampToDate(achievement.getApplyTime()));
        Map<String, Object> map = new HashMap<>();
        map.put("res", achievement);
        return RespBean.ok("操作成功",map);

    }
}
