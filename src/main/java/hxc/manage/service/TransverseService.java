package hxc.manage.service;

import hxc.manage.model.table.Transverse;

import java.util.List;

public interface TransverseService {

    int insert(Transverse pojo);

    int insertSelective(Transverse pojo);

    int insertList(List<Transverse> pojos);

    int update(Transverse pojo);

}
