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

    @Override
    public List<Performance> getPerformanceByUserId(Map<String, Object> map) {
        DateConverter dateConverter = new DateConverter();
        List<Performance> performances = baseInfoMapper.getPerformanceByUserId(map);
        for (Performance p: performances) {
            String time = p.getTime();
            p.setTime(dateConverter.stampToDate(time));
            if (StringUtils.equals(p.getFirst_author(),"1")){
                p.setFirst_author("是");
            }else{
                p.setFirst_author("否");
            }
//            业绩类别
            if (StringUtils.equals(p.getPerformance_class(),"1")){
                p.setPerformance_class("是");
            }else{
                p.setPerformance_class("否");
            }
            //审核情况
            if (StringUtils.equals(p.getAudit_condition(),"1")){
                p.setAudit_condition("通过");
            }else if(StringUtils.equals(p.getAudit_condition(),"2")){
                p.setAudit_condition("审核中");
            }else{
                p.setAudit_condition("未通过");
            }
            //佐证材料上交情况
            if (StringUtils.equals(p.getMaterial_condition(),"1")){
                p.setMaterial_condition("通过");
            }else if(StringUtils.equals(p.getMaterial_condition(),"2")){
                p.setMaterial_condition("审核中");
            }else{
                p.setMaterial_condition("未通过");
            }

        }
        return performances;
    }

}
