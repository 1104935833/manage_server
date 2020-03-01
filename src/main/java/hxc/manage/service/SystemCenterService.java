package hxc.manage.service;


import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SystemCenterService {
    void getYzm(String phone);

    void editPwd(String yzm, String newPwd, Long id);


    List<Map<String, Object>> getPerforEcharts(String user_id, int year);

    List<Map<String, Object>> getPerforEcharts1(String id );

    List<Map<String, Object>> getPerformance(String id,String state1,String state2);

    Map<String, Object> getCountAudit(String user_id);
}
