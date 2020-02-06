package hxc.manage.service;

import java.util.Map;

public interface SystemCenterService {
    void getYzm(String phone);

    void editPwd(String yzm, String newPwd, Long id);

    int changeInfo(Map<String, String> map);

}
