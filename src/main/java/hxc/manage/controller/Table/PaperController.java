package hxc.manage.controller.Table;

import hxc.manage.common.DateConverter;
import hxc.manage.model.Pedding;
import hxc.manage.model.RespBean;
import hxc.manage.model.User;
import hxc.manage.model.table.Paper;
import hxc.manage.service.AuditService;
import hxc.manage.service.PaperService;
import hxc.manage.service.PeddingService;
import hxc.manage.service.TableService;
import hxc.manage.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class PaperController {

    @Autowired
    PaperService paperService;

    @Autowired
    TableService tableService;

    @Autowired
    PeddingService peddingService;

    @Autowired
    AuditService auditService;

    @PostMapping("/insertPaper")
    public RespBean insertPaper(HttpServletRequest request,Paper paper){
        DateConverter dateConverter = new DateConverter();
        User u = (User) request.getSession().getAttribute("userinfo");
        paper.setTime(dateConverter.dateToTimeMillis(paper.getTime()));
        paperService.insert(paper);
        tableService.table(request,u.getUser_id(),String.valueOf(paper.getId()),"tb_paper",7);

        return RespBean.ok("success");
    }

    @PostMapping("/updataPaper")
    public RespBean updataPaper(HttpServletRequest request, @RequestBody Map info) throws ParseException {
        Map<String,Object> map = info;
        DateConverter dateConverter = new DateConverter();
        Paper paper = Util.mapToEntity((Map<String, Object>) map.get("paper"),Paper.class) ;
        String tableId = String.valueOf(info.get("tableId"));
        String id = String.valueOf(info.get("id"));
        paper.setTime(dateConverter.getDateFormat(paper.getTime()));
        paperService.update(paper);
        peddingService.sendPedding(request,tableId,"1","0","4");
        auditService.updateAuit(tableId,"0","0",id,request);
        return RespBean.ok("success");
    }

    @GetMapping("/getPaper")
    public Map<String,Object> getPaper(@RequestParam(required = false) Map param){
        DateConverter dateConverter = new DateConverter();
        Paper res = paperService.getPaper(param);
        res.setTime(dateConverter.stampToDate(res.getTime()));
        Map<String,Object> map = new HashMap<>();
        map.put("res",res);
        return map;
    }


}
