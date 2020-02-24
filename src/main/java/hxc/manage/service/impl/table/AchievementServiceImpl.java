package hxc.manage.service.impl.table;

import hxc.manage.service.table.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import hxc.manage.model.table.Achievement;
import hxc.manage.mapper.AchievementMapper;

@Service
public class AchievementServiceImpl implements AchievementService {

    @Autowired
    private AchievementMapper achievementMapper;

    public int insert(Achievement pojo){
        return achievementMapper.insert(pojo);
    }

    public int insertSelective(Achievement pojo){
        return achievementMapper.insertSelective(pojo);
    }

    public int insertList(List<Achievement> pojos){
        return achievementMapper.insertList(pojos);
    }

    public int update(Achievement pojo){
        return achievementMapper.update(pojo);
    }
}
