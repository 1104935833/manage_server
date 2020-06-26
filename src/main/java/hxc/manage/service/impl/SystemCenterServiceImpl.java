package hxc.manage.service.impl;

import hxc.manage.common.DateConverter;
import hxc.manage.common.EmailAndMessage;
import hxc.manage.mapper.CenterMapper;
import hxc.manage.mapper.PerformanceMapper;
import hxc.manage.model.UserDetail;
import hxc.manage.service.SystemCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    PerformanceMapper performanceMapper;

    @Override
    public void getYzm(String phone) {
        emailAndMessage.send(phone,"2");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
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

    @Override
    public List<Map<String, Object>> getPerformance(String id, String state1, String state2) {
        DateConverter dateConverter = new DateConverter();
        List<Map<String, Object>> map = centerMapper.getPerformance(id,state1,state2);
        Map<String,Object> con = new HashMap<>();
        List<Map<String,Object>> per = new ArrayList<>();
        for (Map<String,Object> m : map){
            con.put("tableName",m.get("table_name"));
            con.put("userId",id);
            con.put("tableId",m.get("id"));
            con.put("audit_status","3");
            Map<String,Object> p =performanceMapper.getPerformanceByUserId1(con);

            if(p!=null){
                p.put("create_time",dateConverter.stampToDate(String.valueOf(p.get("create_time"))));
                String name = String.valueOf(p.get("name"));
                if (name.length()>5) name = name.substring(0,5)+"......";
                p.put("name",name);
                per.add(p);
            }

        }
        return per;
    }

    @Override
    public Map<String, Object> getCountAudit(String user_id) {
        return performanceMapper.getCountAudit(user_id);

    }


}
