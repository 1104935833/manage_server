package hxc.manage.service.impl;

import hxc.manage.model.Office;
import hxc.manage.model.User;
import hxc.manage.mapper.UserMapper;
import hxc.manage.model.UserDetail;
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
        userMapper.delDetailByUserId(split);
        userMapper.delRoleByUserId(split);
        return userMapper.delByUserId(split) == split.length;
    }

    @Override
    public List<Map<String, Object>> getAllTreePeople(String name) {
        List<Map<String,Object>> list;
        list= userMapper.getAllTreePeople(name);
        for (Map<String, Object> map : list) {
            map.remove("parent_id");
            map.remove("id");
            map.remove("tableName");
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
    public List<UserDetail> getUserByPage(Map<String, Object> map) {

        return userMapper.getUserByPage(map);
    }

    @Override
    public Integer getUserByCount(Map<String, Object> map) {
        return userMapper.getUserByCount(map);

    }

    @Override
    public int addUser(List<UserDetail> emps) {
        Integer workId = userMapper.getLastUserWorkId();
        for (UserDetail u : emps) {
            BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
            String newPwd = bcryptPasswordEncoder.encode("123456");
            u.setPassword(newPwd);
            userMapper.addUser(u);
//            u.setUser_id(u.getId()+"");
            workId+=1;
            u.setWorkID(String.format("%08d", workId));
        }
        return userMapper.addEmps(emps);

    }

    @Override
    public void editUser(UserDetail userDetail) {
        userMapper.editUser(userDetail);
        userMapper.editUserDetails(userDetail);
    }

    @Override
    public List<UserDetail> searchInfo(Map<String, Object> map, UserDetail userDetail) {
        List<UserDetail> list =userMapper.searchInfo(map, userDetail);
        return list;
    }

    @Override
    public List<Office> getAllOffice() {
        return userMapper.getAllOffice();
    }

    public List<UserDetail> getAllEmployees() {
        return userMapper.getEmployeeByPage();
    }

}
