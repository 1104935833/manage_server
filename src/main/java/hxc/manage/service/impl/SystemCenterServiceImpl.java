package hxc.manage.service.impl;

import hxc.manage.common.EmailAndMessage;
import hxc.manage.mapper.CenterMapper;
import hxc.manage.model.UserDetail;
import hxc.manage.service.SystemCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SystemCenterServiceImpl implements SystemCenterService {

    @Autowired
    EmailAndMessage emailAndMessage;

    @Autowired
    CenterMapper centerMapper;

    @Override
    public void getYzm(String phone) {
        emailAndMessage.send(phone,"yzm");
    }

    @Override
    public void editPwd(String yzm, String newPwd, Long id) {

        BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
        newPwd = bcryptPasswordEncoder.encode(newPwd);
        centerMapper.editPwd(yzm,newPwd,id);
    }




}
