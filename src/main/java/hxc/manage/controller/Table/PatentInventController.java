package hxc.manage.controller.Table;

import hxc.manage.model.RespBean;
import hxc.manage.model.User;
import hxc.manage.model.table.PatentInvent;
import hxc.manage.service.PatentInventService;
import hxc.manage.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class PatentInventController {

    @Autowired
    PatentInventService patentInventService;

    @Autowired
    TableService tableService;

    @RequestMapping("/insertPatentInvent")
    public RespBean insertPatentInvent(HttpServletRequest request,PatentInvent patentInvent){
        User u = (User) request.getSession().getAttribute("userinfo");
        patentInventService.insert(patentInvent);

        tableService.table(request,u.getUser_id(),String.valueOf(patentInvent.getId()),"tb_patent_invent",patentInvent.getTableState());

        return RespBean.ok("success");
    }



}
