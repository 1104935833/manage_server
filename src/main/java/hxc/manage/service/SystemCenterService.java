package hxc.manage.service;

import hxc.manage.model.UserDetail;

import java.util.Map;

public interface SystemCenterService {
    void getYzm(String phone);

    void editPwd(String yzm, String newPwd, Long id);


}
