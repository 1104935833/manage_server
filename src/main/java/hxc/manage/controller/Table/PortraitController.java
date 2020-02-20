package hxc.manage.controller.Table;

import hxc.manage.model.RespBean;
import hxc.manage.model.User;
import hxc.manage.model.table.Portrait;
import hxc.manage.service.PortraitService;
import hxc.manage.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class PortraitController {

    @Autowired
    PortraitService portraitService;

    @Autowired
    TableService tableService;

    @PostMapping("/insertPortrait")
    public RespBean insertPortrait(HttpServletRequest request,Portrait portrait){
        User u = (User) request.getSession().getAttribute("userinfo");
        portraitService.insert(portrait);

        tableService.table(request,u.getUser_id(),String.valueOf(portrait.getId()),"tb_portrait",4);

        return RespBean.ok("success");
    }


}
