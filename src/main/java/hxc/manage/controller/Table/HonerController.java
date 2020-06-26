package hxc.manage.controller.Table;

import hxc.manage.common.DateConverter;
import hxc.manage.common.JwtTokenProvider;
import hxc.manage.model.User;
import hxc.manage.model.table.Honer;
import hxc.manage.model.RespBean;
import hxc.manage.model.table.Honer;
import hxc.manage.service.AuditService;
import hxc.manage.service.CommonService;
import hxc.manage.service.PeddingService;
import hxc.manage.service.TableService;
import hxc.manage.service.table.HonerService;
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
public class HonerController {

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    HonerService honerService;

    @Autowired
    TableService tableService;

    @Autowired
    PeddingService peddingService;

    @Autowired
    CommonService commonService;

    @Autowired
    AuditService auditService;

    @PostMapping("/insertHoner")
    public RespBean insertHoner(HttpServletRequest request,@RequestBody Honer honer) throws ParseException {
        DateConverter dateConverter = new DateConverter();
        String token = request.getHeader("Authorization");
        User u =jwtTokenProvider.getUserFromToken(token);
        honer.setPersonalGainTime(dateConverter.date1ToTimeMillis(honer.getPersonalGainTime()));
        honer.setCreateTime(String.valueOf(new Date().getTime()));
        int state;
        if (honer.getType()==1){
            state = 22;
        }else{ state=23; }
        int id = tableService.table(request,u.getUser_id(),"honor",state);
        honer.setTableId(id);
        honerService.insert(honer);

        return RespBean.ok("操作成功");
    }

    @PostMapping("/updataHoner")
    public RespBean updataHoner(HttpServletRequest request, @RequestBody Map info) throws ParseException {
        String token = request.getHeader("Authorization");
        User user = jwtTokenProvider.getUserFromToken(token);
        Map<String,Object> map = info;
        DateConverter dateConverter = new DateConverter();
        Honer honer = Util.mapToEntity((Map<String, Object>) map.get("honer"),Honer.class) ;
        String tableId = String.valueOf(info.get("tableId"));
        String id = String.valueOf(info.get("id"));
        honer.setPersonalGainTime(dateConverter.date1ToTimeMillis(honer.getPersonalGainTime()));
        honerService.update(honer);
        peddingService.sendPedding(request,honer.getTableId()+"","1","0","4");
        auditService.updateAuit(tableId,"0","0",id,user);
        return RespBean.ok("操作成功");
    }

    @GetMapping("/getHoner")
    public RespBean getHoner(@RequestParam(required = false) Map param){
        DateConverter dateConverter = new DateConverter();
        Honer res = honerService.getHoner(param);
        List<Map<String,Object>> list = commonService.findOption("honor","","", res.getName());
        for (Map<String,Object> map: list) {
            res.setHoneNameId(Integer.valueOf(res.getName()));
            res.setName(String.valueOf(map.get("label")));
        }

        res.setPersonalGainTime(dateConverter.stampToDate(res.getPersonalGainTime()));
        Map<String,Object> map = new HashMap<>();
        map.put("res",res);
        return RespBean.ok("success",map);
    }

}
