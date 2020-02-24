package hxc.manage.service.impl;

import hxc.manage.common.EmailAndMessage;
import hxc.manage.mapper.CenterMapper;
import hxc.manage.model.UserDetail;
import hxc.manage.service.SystemCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SystemCenterServiceImpl implements SystemCenterService {

    @Autowired
    EmailAndMessage emailAndMessage;

    @Autowired
    CenterMapper centerMapper;

    @Override
    public void getYzm(String phone) {
        emailAndMessage.send(phone,"2");
    }

    @Override
    public void editPwd(String yzm, String newPwd, Long id) {

        BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
        newPwd = bcryptPasswordEncoder.encode(newPwd);
        centerMapper.editPwd(yzm,newPwd,id);
    }

    @Override
    public List<Map<String, Object>> getPerforEcharts(String user_id, int year) {
        List<Map<String, Object>> map = centerMapper.getPerforEcharts(user_id,year);
        return map;
    }

    @Override
    public List<Map<String, Object>> getPerforEcharts1(String id) {
        List<Map<String, Object>> list = centerMapper.getPerforEcharts1(id);

            for (Map<String, Object> m : list) {
                switch (String.valueOf(m.get("name"))) {
                    case "1":
                        m.put("name", "个人科研");
                        break;
                    case "2":
                        m.put("name", "集体科研");
                        break;
                    case "3":
                        m.put("name", "个人荣誉");
                        break;
                    case "4":
                        m.put("name", "集体荣誉");
                        break;
                    case "5":
                        m.put("name", "个人教学业绩");
                        break;
                    case "6":
                        m.put("name", "集体教学业绩");
                        break;
                    default:
                        m.put("name", "其他");
                        break;
                }

        }
        return list;
    }


}
