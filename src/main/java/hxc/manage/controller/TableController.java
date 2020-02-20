package hxc.manage.controller;

import hxc.manage.model.RespBean;

import hxc.manage.service.AuditService;
import hxc.manage.service.PeddingService;
import hxc.manage.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class TableController {

    @Autowired
    PeddingService peddingService;

    @Autowired
    AuditService auditService;

    @GetMapping("/check")
    public RespBean check(@RequestParam("tableId") String tableId,
                          @RequestParam("type") String type,//1教研室2分院
                          @RequestParam("status") String status,//1通过2未通过
                          @RequestParam("id") String id,//audit表id
                          @RequestParam("agree") String agree,//0 -- 不同意 1 -- 同意
                          @RequestParam("tableName")String state,
                          HttpServletRequest request){//  tableName 到哪个阶段了1首次发起2教研室3分院4返回修改在发起
        int i;
        i=auditService.updateAuit(tableId,type,status,id,request);
        i+=peddingService.sendPedding(request,tableId,"",agree,state);
        if(i>1)
            return RespBean.ok("操作成功");
        else
            return RespBean.error("操作失败");
    }

}
