package hxc.manage.controller;

import hxc.manage.model.Audit;
import hxc.manage.model.RespBean;
import hxc.manage.model.Table;
import hxc.manage.model.User;
import hxc.manage.service.AuditService;
import hxc.manage.service.PeddingService;
import hxc.manage.service.TableService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.util.Date;
import java.util.Map;


@RestController
public class TableController {

    @Autowired
    PeddingService peddingService;

    @Autowired
    TableService tableService;

    @Autowired
    AuditService auditService;

    /**
     * 新建表格
     * 1.table插入（先插入各表然后获取id插入table表）
     * 2.audit插入
     * 3.pedding插入
     * @param table
     * @param request
     * @return
     */
    @PostMapping("/table")
    public RespBean table(@RequestBody Map table, HttpServletRequest request){
        Map<String,Object> map = (Map<String, Object>) table.get("table");
        User u = (User) request.getSession().getAttribute("userinfo");
        /**
         * 此处插入各表数据返回id
         */
        Table tab = new Table();
        tab.setUserId(Integer.valueOf(u.getUser_id()));
        tab.setTableId("。。。。。。。。。。。。。。。");//需要更改为各表id
        tab.setState(2);//类型暂定
        tableService.insert(tab);//table插入
        peddingService.sendPedding(request,tab.getId().toString(),"1","","1");//pedding插入    type:暂定为1
        Audit audit = new Audit();
        audit.setProposerId(Integer.valueOf(u.getUser_id()));
        audit.setProposerType("1");//类型暂定
        audit.setProposerTime(new Date().getTime()+"");
        audit.setTableId(tab.getId());
        audit.setAuditStatus(0);
        auditService.insert(audit);//audit插入
        return RespBean.ok("提交成功");
    }

    @GetMapping("/check")
    public RespBean check(@RequestParam("tableId") String tableId,
                          @RequestParam("type") String type,//1教研室2分院
                          @RequestParam("status") String status,//1通过2未通过
                          @RequestParam("id") String id,//audit表id
                          @RequestParam("agree") String agree,//0 -- 不同意 1 -- 同意
                          @RequestParam("state")String state,
                          HttpServletRequest request){//  state 到哪个阶段了1首次发起2教研室3分院4返回修改在发起
        int i;
        i=auditService.updateAuit(tableId,type,status,id,request);
        i+=peddingService.sendPedding(request,tableId,"",agree,state);
        if(i>1)
            return RespBean.ok("操作成功");
        else
            return RespBean.error("操作失败");
    }

}
