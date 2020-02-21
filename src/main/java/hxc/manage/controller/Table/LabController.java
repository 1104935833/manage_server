package hxc.manage.controller.Table;

import hxc.manage.model.RespBean;
import hxc.manage.model.User;
import hxc.manage.model.table.Lab;
import hxc.manage.service.LabService;
import hxc.manage.service.TableService;
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
public class LabController {
    @Autowired
    LabService labService;

    @Autowired
    TableService tableService;

    @PostMapping("/insertLab")
    public RespBean insertLab(HttpServletRequest request, Lab lab){
        User u = (User) request.getSession().getAttribute("userinfo");
        labService.insert(lab);
        tableService.table(request,u.getUser_id(),String.valueOf(lab.getId()),"jt_lab",8);
        return RespBean.ok("success");
    }

    @GetMapping("/getLabs")
    public Map<String,Object> getLabs(@RequestParam(required = false) Map param){
        List<Map<String,Object>> res = labService.getLabs(param);
        Map<String,Object> map = new HashMap<>();
        map.put("res",res);
        return map;
    }

}
