package hxc.manage.service;

import java.util.List;
import java.util.Map;

public interface PerformanceService {


    List<Map<String,Object>> getPerformanceByUserId(Map<String, Object> map);

    List<Map<String,Object>> getperType(String state);

    List<Map<String, Object>> searchPerNameNotNull(Map<String, Object> map);

    List<Map<String, Object>> searchPerOther(Map<String, Object> map);

    List<Map<String, Object>> getperTypeGroup();

    List<Map<String, Object>> getperTypeSelf();
}
