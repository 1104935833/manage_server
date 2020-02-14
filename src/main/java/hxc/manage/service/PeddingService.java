package hxc.manage.service;

import hxc.manage.model.Pedding;
import hxc.manage.model.Role;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author hxc
 * @version 1.0
 * @date 2019/12/12 14:15
 */
public interface PeddingService {
    Map<String, Object> getPeddingName(List<Role> roles, String userId, int size, int start);

//    Integer sendPedding(Pedding pedding, String userId, String agree, String state);
    int sendPedding(HttpServletRequest req,
                                           String tableId,
                                           String type,//个人or集体;1,2
                                           String agree,
                                           String state);

//    List<SysRole> findSysRole();

}
