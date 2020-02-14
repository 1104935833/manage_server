package hxc.manage.service;

import hxc.manage.model.Table;

import java.util.List;

public interface TableService {

    int insert(Table pojo);

    int insertSelective(Table pojo);

    int insertList(List<Table> pojos);

    int update(Table pojo);

}
