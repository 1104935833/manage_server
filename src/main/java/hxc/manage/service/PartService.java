package hxc.manage.service;

import hxc.manage.model.Role;

import java.util.List;
import java.util.Map;

/**
 * @author hxc
 * @version 1.0
 * @date 2020/1/19 16:21
 */
public interface PartService {

    void addPart(String name, String nameZh);

    Map<String, List> getTrandferUser(String rid, String type);

    void editPartUser(List parts, Integer partId, String type, Integer length);

    void editPart(Map map);

    void delPart(String id,Integer state);

    Map<String, Object> getPartMenuById(String id);

    List<Role> getAllRole();

}
