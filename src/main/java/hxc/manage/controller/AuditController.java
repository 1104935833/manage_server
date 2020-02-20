package hxc.manage.controller;


import hxc.manage.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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


    @GetMapping("/getTableName")
    public Map<String,Object> getTableName(@RequestParam("tableId") String tableId){
        Map<String,Object> map = new HashMap<>();
        String tableName = auditService.getTableName(tableId);
        map.put("tableName",tableName);



        return map;
    }




}
