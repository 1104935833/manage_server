package hxc.manage.service.table;

import hxc.manage.model.table.Competition;

import java.util.List;

public interface CompetitionService {

    int insert(Competition pojo);

    int insertSelective(Competition pojo);

    int insertList(List<Competition> pojos);

    int update(Competition pojo);
}
