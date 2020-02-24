package hxc.manage.service;

import hxc.manage.model.Audit;
import hxc.manage.model.RespBean;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface AuditService {

    int insert(Audit pojo);

    int insertSelective(Audit pojo);

    int insertList(List<Audit> pojos);

    int update(Audit pojo);

    List<Map<String, Object>> getAllAudit(Map<String, Object> conditions);

    int updateAuit(String tableId,
                        String type,//1教研室2分院
                        String status,//1通过2未通过
                        String id,
                        HttpServletRequest request);

    Map<String,Object> getTableName(String tableId);

    int getAllAuditCount(Map<String, Object> conditions);
}
