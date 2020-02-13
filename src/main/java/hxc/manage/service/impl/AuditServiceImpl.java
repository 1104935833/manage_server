package hxc.manage.service.impl;

import hxc.manage.common.DateConverter;
import hxc.manage.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import hxc.manage.model.Audit;
import hxc.manage.mapper.AuditMapper;

@Service
public class AuditServiceImpl implements AuditService {

    @Autowired
    private AuditMapper auditMapper;

    @Override
    public int insert(Audit pojo){
        return auditMapper.insert(pojo);
    }

    @Override
    public int insertSelective(Audit pojo){
        return auditMapper.insertSelective(pojo);
    }

    @Override
    public int insertList(List<Audit> pojos){
        return auditMapper.insertList(pojos);
    }

    @Override
    public int update(Audit pojo){
        return auditMapper.update(pojo);
    }

    @Override
    public List<Map<String, Object>> getAllAudit(Map<String, Object> conditions) {
        List<Map<String, Object>> audits=auditMapper.getAllAudit(conditions);
        DateConverter dateConverter = new DateConverter();
        for (Map<String,Object> a: audits) {
            a.put("proposer_time",dateConverter.stampToDate(a.get("proposer_time")+""));
            a.put("auditor_research_time",dateConverter.stampToDate(a.get("auditor_research_time")+""));
            a.put("audtior_court_time",dateConverter.stampToDate(a.get("audtior_court_time")+""));
        }
        return audits;
    }

    @Override
    public int updateAuit(Map<String, Object> conditions) {

        int i = auditMapper.updateAuit(conditions);

        return i;
    }
}
