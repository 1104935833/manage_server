package hxc.manage.controller.Table;

import hxc.manage.model.RespBean;
import hxc.manage.model.User;
import hxc.manage.model.table.Transverse;
import hxc.manage.service.TableService;
import hxc.manage.service.TransverseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class TransverseController {

    @Autowired
    TransverseService transverseService;

    @Autowired
    TableService tableService;

    @PostMapping("/insertTransverse")
    public RespBean insertTransverse(HttpServletRequest request,Transverse transverse){
        User u = (User) request.getSession().getAttribute("userinfo");
        transverseService.insert(transverse);
        tableService.table(request,u.getUser_id(),String.valueOf(transverse.getId()),"tb_transverse",5);
        return RespBean.ok("success");
    }




}
