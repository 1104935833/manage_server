package hxc.manage.service;

import hxc.manage.model.table.PatentInvent;

import java.util.List;

public interface PatentInventService {

    int insert(PatentInvent pojo);

    int insertSelective(PatentInvent pojo);

    int insertList(List<PatentInvent> pojos);

    int update(PatentInvent pojo);
}
