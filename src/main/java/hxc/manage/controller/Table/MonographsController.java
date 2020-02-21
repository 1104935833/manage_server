package hxc.manage.controller.Table;

import hxc.manage.model.RespBean;
import hxc.manage.model.User;
import hxc.manage.model.table.Monographs;
import hxc.manage.service.MonographsService;
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
public class MonographsController {

    @Autowired
    MonographsService monographsService;

    @Autowired
    TableService tableService;

    @PostMapping("/insertMonographs")
    public RespBean insertMonographs(HttpServletRequest request, Monographs monographs){

        User u = (User) request.getSession().getAttribute("userinfo");

        monographsService.insert(monographs);

        tableService.table(request,u.getUser_id(),String.valueOf(monographs.getId()),"tb_monographs",8);

        return RespBean.ok("success");
    }

    @GetMapping("/getMonographs")
    public Map<String,Object> getMonographs(@RequestParam(required = false) Map param){

        List<Map<String,Object>> res = monographsService.getMonographs(param);
        Map<String,Object> map = new HashMap<>();
        map.put("res",res);
        return map;
    }


}
