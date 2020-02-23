package hxc.manage.service;

import hxc.manage.model.Office;
import hxc.manage.model.Performance;
import hxc.manage.model.UserDetail;

import java.util.List;
import java.util.Map;

public interface BaseInfoService {

    int changeInfo(Map<String, String> map);

    UserDetail userInfo(Long id);

    List<Office> getOffices();


}
