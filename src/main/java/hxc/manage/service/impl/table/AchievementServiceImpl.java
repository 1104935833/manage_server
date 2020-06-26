package hxc.manage.service.impl.table;

import hxc.manage.service.table.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

import hxc.manage.model.table.Achievement;
import hxc.manage.mapper.AchievementMapper;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AchievementServiceImpl implements AchievementService {

    @Autowired
    private AchievementMapper achievementMapper;

    @Transactional(rollbackFor = Exception.class)
    public int insert(Achievement pojo){
        return achievementMapper.insert(pojo);
    }

    @Transactional(rollbackFor = Exception.class)
    public int insertSelective(Achievement pojo){
        return achievementMapper.insertSelective(pojo);
    }

    @Transactional(rollbackFor = Exception.class)
    public int insertList(List<Achievement> pojos){
        return achievementMapper.insertList(pojos);
    }

    @Transactional(rollbackFor = Exception.class)
    public int update(Achievement pojo){
        return achievementMapper.update(pojo);
    }

    @Override
    public Achievement getAchievement(Map<String, Object> param) {
        return achievementMapper.getAchievement(param);
    }
}
