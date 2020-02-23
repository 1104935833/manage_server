package hxc.manage.service;

import hxc.manage.model.Performance;

import java.util.List;
import java.util.Map;

public interface PerformanceService {


    List<Map<String,Object>> getPerformanceByUserId(Map<String, Object> map);

}
