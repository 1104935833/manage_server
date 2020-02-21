package hxc.manage.service;

import java.util.List;

public interface TechnologicalService {

    int insert(hxc.manage.model.table.Technological pojo);

    int insertSelective(hxc.manage.model.table.Technological pojo);

    int insertList(List<hxc.manage.model.table.Technological> pojos);

    int update(hxc.manage.model.table.Technological pojo);

}
