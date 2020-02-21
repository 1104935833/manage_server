package hxc.manage.controller.Table;

import hxc.manage.model.RespBean;
import hxc.manage.model.User;
import hxc.manage.model.table.FirstSubject;
import hxc.manage.service.FirstSubjectService;
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
public class FirstSubjectController {
    @Autowired
    FirstSubjectService firstSubjectService;

    @Autowired
    TableService tableService;

    @PostMapping("/insertFirstSubject")
    public RespBean insertFirstSubject(HttpServletRequest request, FirstSubject firstSubject){
        User u = (User) request.getSession().getAttribute("userinfo");
        firstSubjectService.insert(firstSubject);
        tableService.table(request,u.getUser_id(),String.valueOf(firstSubject.getId()),"jt_first_subject",7);
        return RespBean.ok("success");
    }

    @GetMapping("/getFirstSubjects")
    public Map<String,Object> getFirstSubject(@RequestParam(required = false) Map param){
        List<Map<String,Object>> res = firstSubjectService.getFirstSubjects(param);
        Map<String,Object> map = new HashMap<>();
        map.put("res",res);
        return map;
    }

}
