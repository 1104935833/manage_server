package hxc.manage.service.impl;

import hxc.manage.mapper.EmpMapper;
import hxc.manage.model.UserDetails;
import hxc.manage.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

/**
 * @author hxc
 * @version 1.0
 * @date 2019/12/27 14:26
 */
@Service
@Transactional
public class EmpServiceImpl implements EmpService {

    @Autowired
    EmpMapper empMapper;

    public boolean delByUserId(String ids) {
        String[] split = ids.split(",");
        return empMapper.delByUserId(split) == split.length;
    }

    public List<UserDetails> getAllEmployees() {
        return empMapper.getEmployeeByPage();
    }

    @Override
    public List<Map<String, Object>> getAllTreePeople(String name) {
        List<Map<String,Object>> list;
        list= empMapper.getAllTreePeople(name);
        for (Map<String, Object> map : list) {
            map.remove("parent_id");
            map.remove("id");
            map.remove("state");
        }
        return list;
    }

    @Override
    public List<Map<String, Object>> getAllTreePeople1(String name) {
        List<Map<String,Object>> list;
        list= empMapper.getAllTreePeople1(name);

        return list;
    }



    @Override
    public List<UserDetails> getUserByPage(Map<String, Object> map) {

        return empMapper.getUserByPage(map);
    }

    @Override
    public Integer getUserByCount(Map<String, Object> map) {
        return empMapper.getUserByCount(map);

    }


    @Override
    public int addUser(List<UserDetails> emps) {
        Integer workId = empMapper.getLastUserWorkId();
        for (UserDetails u : emps) {
             empMapper.addUser(u);
//            u.setUser_id(u.getId()+"");
            u.setWorkID(String.format("%08d", workId + 1));
        }
        return empMapper.addEmps(emps);

    }

    @Override
    public void editUser(UserDetails userDetails) {
        empMapper.editUser(userDetails);
        empMapper.editUserDetails(userDetails);
    }

    @Override
    public List<UserDetails> searchInfo(Map<String, Object> map, UserDetails userDetails) {
        List<UserDetails> list =empMapper.searchInfo(map,userDetails);
        return list;
    }
}
