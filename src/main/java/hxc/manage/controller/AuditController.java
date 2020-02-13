package hxc.manage.controller;


import hxc.manage.model.RespBean;
import hxc.manage.model.User;
import hxc.manage.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AuditController {

    @Autowired
    AuditService auditService;
    //全部的审核列表
    @GetMapping("/getAllAudit")
    public Map<String, Object> getAllAudit(@RequestParam("proposer_id") String proposer_id,
                                           @RequestParam("audit_status") String audit_status,
                                           @RequestParam(defaultValue = "1") Integer page,
                                           @RequestParam(defaultValue = "10") Integer size){
        int start = (page - 1) * size;
        Map<String,Object> conditions = new HashMap<>();
        conditions.put("proposer_id",proposer_id);
        conditions.put("audit_status",audit_status);
        conditions.put("start",start);
        conditions.put("size",size);
        List<Map<String, Object>> audits= auditService.getAllAudit(conditions);

        Map<String,Object> map = new HashMap<>();
        map.put("audits",audits);
        map.put("count",audits.size());
        return map;
    }

    //审核
    @PostMapping("/check")
    public RespBean check(@RequestParam("tableId") String tableId,
                          @RequestParam("type") String type,//1教研室2分院
                          @RequestParam("status") String status,//1通过2未通过
                          @RequestParam("id") String id,
                          HttpServletRequest request){
        User u = (User) request.getSession().getAttribute("userinfo");
        Map<String,Object> conditions = new HashMap<>();
        conditions.put("tableId",tableId);
        conditions.put("id",id);
        if (type.equals("1") && status.equals("1")){
            status="1";
        }else if(type.equals("1") && status.equals("2")){
            status="2";
        }else if(type.equals("2") && status.equals("1")){
            status="3";
        }else if(type.equals("2") && status.equals("2")){
            status="4";
        }
        conditions.put("auditStatus",status);
        if (type.equals("1")){
            conditions.put("auditorResearchId",u.getUser_id());
            conditions.put("auditorResearchTime",new Date().getTime());
        }else{
            conditions.put("auditorCourtId",u.getUser_id());
            conditions.put("audtiorCourtTime",new Date().getTime());
        }

        int i = auditService.updateAuit(conditions);

        if (i>0)
            return RespBean.ok("操作成功");
        else
            return RespBean.error("操作失败");


    }




}
