package hxc.manage.controller.Table;

import hxc.manage.model.RespBean;
import hxc.manage.model.User;
import hxc.manage.model.table.Academic;
import hxc.manage.service.AcademicService;
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
public class AcademicController {
    @Autowired
    AcademicService academicService;

    @Autowired
    TableService tableService;

    @PostMapping("/insertAcademic")
    public RespBean insertAcademic(HttpServletRequest request, Academic academic){
        User u = (User) request.getSession().getAttribute("userinfo");
        academicService.insert(academic);
        tableService.table(request,u.getUser_id(),String.valueOf(academic.getId()),"jt_academic_innovation",6);
        return RespBean.ok("success");
    }

    @GetMapping("/getAcademics")
    public Map<String,Object> getAcademics(@RequestParam(required = false) Map param){
        List<Map<String,Object>> res = academicService.getAcademics(param);
        Map<String,Object> map = new HashMap<>();
        map.put("res",res);
        return map;
    }
}
