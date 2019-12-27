package hxc.manage.service.impl;

import hxc.manage.model.User;
import hxc.manage.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author hxc
 * @version 1.0
 * @date 2019/12/27 14:26
 */
@Service
@Transactional
public class UserServiceImpl implements UserDetailsService {

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

    public int userReg(String username, String password) {
        //如果用户名存在，返回错误
        if (userMapper.loadUserByUsername(username) != null) {
            return -1;
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode(password);
        return userMapper.userReg(username, encode);
    }

    public List<User> getHrsByKeywords(String keywords) {
        return userMapper.getUsersByKeywords(keywords);
    }

    public int updateHr(User user) {
        return userMapper.updateUser(user);
    }

    public int updateHrRoles(Long userId, Long[] rids) {
        int i = userMapper.deleteRoleByUserId(userId);
        return userMapper.addRolesForUser(userId, rids);
    }

    public User getHrById(Long userId) {
        return userMapper.getUserById(userId);
    }

    public int deleteHr(Long userId) {
        return userMapper.deleteUser(userId);
    }
}
