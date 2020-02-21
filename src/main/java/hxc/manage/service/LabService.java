package hxc.manage.service;

import hxc.manage.model.table.Lab;

import java.util.List;
import java.util.Map;

public interface LabService {

    int insert(Lab pojo);

    int insertSelective(Lab pojo);

    int insertList(List<Lab> pojos);

    int update(Lab pojo);

    List<Map<String,Object>> getLabs(Map param);
}
