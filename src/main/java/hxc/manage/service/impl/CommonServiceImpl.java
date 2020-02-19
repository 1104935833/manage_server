package hxc.manage.service.impl;

import hxc.manage.mapper.CommonMapper;
import hxc.manage.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    CommonMapper commonMapper;

    @Override
    public List<Map<String, Object>> findOption(String option, String title, String value) {
        return commonMapper.findOption(option,title,value);
    }
}
