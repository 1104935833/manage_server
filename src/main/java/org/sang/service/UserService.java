package org.sang.service;

import org.sang.model.User;
import org.sang.common.UserUtils;
import org.sang.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sang on 2017/12/28.
 */
@Service
@Transactional
public class UserService implements UserDetailsService {

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

    public List<User> getAllHrExceptAdmin() {
        return userMapper.getAllUser(UserUtils.getCurrentHr().getId());
    }
    public List<User> getAllHr() {
        return userMapper.getAllUser(null);
    }
}
