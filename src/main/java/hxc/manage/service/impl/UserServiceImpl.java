package hxc.manage.service.impl;

import hxc.manage.model.User;
import hxc.manage.mapper.UserMapper;
import hxc.manage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userMapper.loadUserByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不对");
        }
        return user;
    }

    public boolean delByUserId(String ids) {
        String[] split = ids.split(",");
        return userMapper.delByUserId(split) == split.length;
    }

    @Override
    public List<Map<String, Object>> getAllTreePeople(String name) {
        List<Map<String,Object>> list;
        list= userMapper.getAllTreePeople(name);
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
        list= userMapper.getAllTreePeople1(name);

        return list;
    }



    @Override
    public List<hxc.manage.model.UserDetails> getUserByPage(Map<String, Object> map) {

        return userMapper.getUserByPage(map);
    }

    @Override
    public Integer getUserByCount(Map<String, Object> map) {
        return userMapper.getUserByCount(map);

    }

    @Override
    public int addUser(List<hxc.manage.model.UserDetails> emps) {
        Integer workId = userMapper.getLastUserWorkId();
        for (hxc.manage.model.UserDetails u : emps) {
            userMapper.addUser(u);
//            u.setUser_id(u.getId()+"");
            u.setWorkID(String.format("%08d", workId + 1));
        }
        return userMapper.addEmps(emps);

    }

    @Override
    public void editUser(hxc.manage.model.UserDetails userDetails) {
        userMapper.editUser(userDetails);
        userMapper.editUserDetails(userDetails);
    }

    @Override
    public List<hxc.manage.model.UserDetails> searchInfo(Map<String, Object> map, hxc.manage.model.UserDetails userDetails) {
        List<hxc.manage.model.UserDetails> list =userMapper.searchInfo(map,userDetails);
        return list;
    }

    public List<hxc.manage.model.UserDetails> getAllEmployees() {
        return userMapper.getEmployeeByPage();
    }

}
