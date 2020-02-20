package hxc.manage.controller.Table;

import hxc.manage.model.RespBean;
import hxc.manage.model.User;
import hxc.manage.model.table.Paper;
import hxc.manage.service.PaperService;
import hxc.manage.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class PaperController {

    @Autowired
    PaperService paperService;

    @Autowired
    TableService tableService;

    @PostMapping("/insertPaper")
    public RespBean insertPaper(HttpServletRequest request,Paper paper){
        User u = (User) request.getSession().getAttribute("userinfo");
        paperService.insert(paper);
        tableService.table(request,u.getUser_id(),String.valueOf(paper.getId()),"tb_paper",2);

        return RespBean.ok("success");
    }



}
