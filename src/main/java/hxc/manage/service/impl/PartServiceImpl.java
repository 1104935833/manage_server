package hxc.manage.service.impl;

import com.alibaba.druid.util.StringUtils;
import hxc.manage.mapper.MenuMapper;
import hxc.manage.mapper.PartMapper;
import hxc.manage.model.Part;
import hxc.manage.model.Role;
import hxc.manage.service.MenuService;
import hxc.manage.service.PartService;
import hxc.manage.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hxc
 * @version 1.0
 * @date 2020/1/19 16:48
 */
@Service
@Transactional
public class PartServiceImpl implements PartService {

    @Autowired
    PartMapper partMapper;


    @Autowired
    RedisUtil redisUtil;

    @Override
    public void addPart(String name, String nameZh) {
        partMapper.addPart(name,nameZh);
    }

    @Override
    public Map<String, List> getTrandferUser(String rid) {
        List<Map<String,Object>> leftmap = partMapper.getTrandferUser(rid,"left");
        List<Map<String,Object>> rightmap = partMapper.getTrandferUser(rid,"right");
        List leftLabel = new ArrayList();
        List leftValue = new ArrayList();
        List rightLabel = new ArrayList();
        List rightValue = new ArrayList();
        for (Map<String, Object> map:leftmap){
            leftLabel.add(map.get("name"));
            leftValue.add(map.get("id"));
        }
        for (Map<String, Object> map:rightmap) {
            rightLabel.add(map.get("name"));
            rightValue.add(map.get("id"));
        }
        Map<String,List> map = new HashMap<>();
        map.put("leftLabel",leftLabel);
        map.put("leftValue",leftValue);
        map.put("rightLabel",rightLabel);
        map.put("rightValue",rightValue);
        return map;
    }

    @Override
    public void editPartUser(List parts, Integer partId) {
        partMapper.delPartUserById(partId);
        partMapper.editPartUser(parts,partId);


    }

    @Override
    public void editPart(Map map) {
        Map form = (Map) map.get("form");
        partMapper.updateRoleById(form);
        Integer id = (Integer) form.get("id");
        partMapper.delMenuRole(id);
        List list = (List) map.get("nodes");
        if (list.size()>0) {
            Map<String, Object> nodes = new HashMap<>();
            nodes.put("list", list);
            nodes.put("id", id);
            partMapper.insertMenuRole(nodes);
        }
    }

    @Override
    public void delPart(String id,Integer state) {
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("state",state);
        partMapper.updateRoleById(map);
    }

    @Override
    public Map<String, Object> getPartMenuById(String id) {
        Map<String, Object> res = new HashMap<>();

        List<Map<String, Object>> map;
        if(StringUtils.equals(id,"")) {
            List<Part> list;
            list= (List<Part>) redisUtil.get("part");
            if(list==null){
                list = partMapper.getPartMenuById(id);
                for (Part pa : list) {
                    map = partMapper.getPartMenuSon(pa.getId() + "","1");
                    pa.setChildren(map);
                }
                redisUtil.set("part",list);
            }
            res.put("part", list);

        }
        else {
            List tmp = new ArrayList();
            List<Map<String, Object>> list =  partMapper.getPartMenuSon(id + "","0");
            for (Map<String, Object> l:list) {
                tmp.add(l.get("id"));
            }
            res.put("part", tmp);
        }
        return res;
    }

    @Override
    public List<Role> getAllRole() {

        return partMapper.getAllRole();
    }


}
