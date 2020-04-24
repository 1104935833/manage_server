package hxc.manage.controller;


import hxc.manage.mapper.RoleMapper;
import hxc.manage.model.RespBean;
import hxc.manage.model.Role;
import hxc.manage.model.User;
import hxc.manage.service.AuditService;
import hxc.manage.service.PeddingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AuditController {

    @Autowired
    PeddingService peddingService;

    @Autowired
    RoleMapper roleMapper;

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
        map.put("count",auditService.getAllAuditCount(conditions));
        return map;
    }


    @GetMapping("/getTableName")
    public Map<String,Object> getTableName(@RequestParam("tableId") String tableId){
        Map<String,Object> map = new HashMap<>();
        map.put("tableName",auditService.getTableName(tableId));
        return map;
    }




    @GetMapping("/check")
    public RespBean check(@RequestParam("tableId") String tableId,
                          @RequestParam("userId") String userId,
                          @RequestParam("status") String status,//1通过2未通过
                          @RequestParam("id") String id,//audit表id
                          @RequestParam("agree") String agree,//0 -- 不同意 1 -- 同意
                          HttpServletRequest request){
        int i;
        String type="1";//1教研室2分院
        String state="1";//  state 到哪个阶段了2教研室3分院4返回修改在发起
        User u= (User) request.getSession().getAttribute("userinfo");
        Long role =  u.getRoles().get(0).getId();
        int roles = roleMapper.getUserRole(userId);
        if((role!=roles && !state.equals("2")) && role!=6){
            return RespBean.error("您没有审核此记录的权限");
        }else{
            for (Role r :u.getRoles()){
                if (r.getNameZh().equals("分院管理员")){
                    type="2";
                    state="3";
                    break;
                }else{
                    type="1";
                    state="2";
                }
            }
            i=auditService.updateAuit(tableId,type,status,id,request);
            i+=peddingService.sendPedding(request,tableId,type,agree,state);
            if(i>1)
                return RespBean.ok("操作成功");
            else
                return RespBean.error("操作失败");
        }

    }


}
