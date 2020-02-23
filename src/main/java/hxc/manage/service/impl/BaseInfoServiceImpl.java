package hxc.manage.service.impl;

import com.alibaba.druid.util.StringUtils;
import hxc.manage.common.DateConverter;
import hxc.manage.mapper.BaseInfoMapper;
import hxc.manage.model.Office;
import hxc.manage.model.Performance;
import hxc.manage.model.UserDetail;
import hxc.manage.service.BaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BaseInfoServiceImpl implements BaseInfoService {

    @Autowired
    BaseInfoMapper baseInfoMapper;

    @Override
    public int changeInfo(Map<String, String> map) {
        int i =baseInfoMapper.changeInfo(map);
        return i;
    }

    @Override
    public UserDetail userInfo(Long id) {
        UserDetail detail = baseInfoMapper.userInfo(id);
        return detail;
    }

    @Override
    public List<Office> getOffices() {
        List<Office> offices = baseInfoMapper.getOffices();
        return offices;
    }



}
