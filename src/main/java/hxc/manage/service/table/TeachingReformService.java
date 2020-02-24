package hxc.manage.service.table;

import hxc.manage.model.table.TeachingReform;

import java.util.List;

public interface TeachingReformService {

    int insert(TeachingReform pojo);

    int insertSelective(TeachingReform pojo);

    int insertList(List<TeachingReform> pojos);

    int update(TeachingReform pojo);
}
