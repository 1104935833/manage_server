package hxc.manage.service;

import hxc.manage.model.table.Lab;

import java.util.List;

public interface LabService {

    int insert(Lab pojo);

    int insertSelective(Lab pojo);

    int insertList(List<Lab> pojos);

    int update(Lab pojo);

}
