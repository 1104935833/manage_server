package hxc.manage.controller.Table;

import hxc.manage.model.RespBean;
import hxc.manage.model.User;
import hxc.manage.model.table.ProductionUnion;
import hxc.manage.model.table.Technological;
import hxc.manage.service.TableService;
import hxc.manage.service.TechnologicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TechnologicalController {

    @Autowired
    TechnologicalService technologicalService;

    @Autowired
    TableService tableService;

    @PostMapping("/insertTechnological")
    public RespBean insertTechnological(HttpServletRequest request, Technological technological){
        User u = (User) request.getSession().getAttribute("userinfo");
        technologicalService.insert(technological);
        tableService.table(request,u.getUser_id(),String.valueOf(technological.getId()),"jt_technological_innovation",10);
        return RespBean.ok("success");
    }

    @GetMapping("getTechnologicals")
    public Map<String,Object> getTechnologicals(@RequestParam(required = false) Map param){
        List<Map<String,Object>> res = technologicalService.getTechnologicals(param);
        Map<String,Object> map = new HashMap<>();
        map.put("res",res);
        return map;
    }

}
