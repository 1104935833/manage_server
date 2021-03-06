package hxc.manage.service.impl;

import hxc.manage.common.DateConverter;
import hxc.manage.model.User;
import hxc.manage.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hxc.manage.model.Audit;
import hxc.manage.mapper.AuditMapper;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

@Service
public class AuditServiceImpl implements AuditService {

    @Autowired
    private AuditMapper auditMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(Audit pojo){
        return auditMapper.insert(pojo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertSelective(Audit pojo){
        return auditMapper.insertSelective(pojo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertList(List<Audit> pojos){
        return auditMapper.insertList(pojos);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int update(Audit pojo){
        return auditMapper.update(pojo);
    }

    @Override
    public List<Map<String, Object>> getAllAudit(Map<String, Object> conditions) {
        List<Map<String, Object>> audits=auditMapper.getAllAudit(conditions);
        DateConverter dateConverter = new DateConverter();
        for (Map<String,Object> a: audits) {
            if(a.containsKey("auditor_research_time")){//判断是否有这个键
                a.put("auditor_research_time",dateConverter.stampToDate(a.get("auditor_research_time")+""));
            }
            if(a.containsKey("audtior_court_time")){
                a.put("audtior_court_time",dateConverter.stampToDate(a.get("audtior_court_time")+""));
            }
            if(a.containsKey("proposer_time")){
                a.put("proposer_time",dateConverter.stampToDate(a.get("proposer_time")+""));
            }

        }
        return audits;
    }


    //审核
    @Transactional(rollbackFor = Exception.class)
    public int updateAuit(String tableId,
                            String type,//1教研室2分院
                            String status,//1通过2未通过
                            String id,//表id
                            User user){
//        User u = (User) request.getSession().getAttribute("userinfo");
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
        }else{
            status="0";
        }
        conditions.put("auditStatus",status);
        if (type.equals("1")){
            conditions.put("auditorResearchId",user.getUser_id());
            conditions.put("auditorResearchTime",new Date().getTime());
        }else if (type.equals("2")){
            conditions.put("auditorCourtId",user.getUser_id());
            conditions.put("auditorCourtTime",new Date().getTime());
        }else{
            conditions.put("isNull","1");
            conditions.put("auditorResearchId",null);
            conditions.put("auditorResearchTime",null);
        }

        int i = auditMapper.updateAuit(conditions);
        return i;
    }

    @Override
    public Map<String,Object> getTableName(String tableId) {



        return auditMapper.getTableName(tableId);
    }

    @Override
    public int getAllAuditCount(Map<String, Object> conditions) {
        return auditMapper.getAllAuditCount(conditions);
    }

    @Override
    public Integer isCheck(Integer userId, Integer tableId, Integer status) {
        return auditMapper.isCheck(userId,tableId,status);
    }


}
