package hxc.manage.service.table;

import hxc.manage.model.table.Achievement;

import java.util.List;

public interface AchievementService {

    int insert(Achievement pojo);

    int insertSelective(Achievement pojo);

    int insertList(List<Achievement> pojos);

    int update(Achievement pojo);
}
