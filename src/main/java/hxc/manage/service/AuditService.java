package hxc.manage.service;

import hxc.manage.model.Audit;

import java.util.List;
import java.util.Map;

public interface AuditService {

    int insert(Audit pojo);

    int insertSelective(Audit pojo);

    int insertList(List<Audit> pojos);

    int update(Audit pojo);

    List<Map<String, Object>> getAllAudit(Map<String, Object> conditions);

    int updateAuit(Map<String, Object> conditions);
}
