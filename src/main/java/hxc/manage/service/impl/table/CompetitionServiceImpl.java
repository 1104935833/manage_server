package hxc.manage.service.impl.table;

import hxc.manage.service.CommonService;
import hxc.manage.service.table.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import hxc.manage.model.table.Competition;
import hxc.manage.mapper.CompetitionMapper;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CompetitionServiceImpl implements CompetitionService {

    @Autowired
    private CompetitionMapper competitionMapper;

    @Transactional(rollbackFor = Exception.class)
    public int insert(Competition pojo){
        return competitionMapper.insert(pojo);
    }

    @Transactional(rollbackFor = Exception.class)
    public int insertSelective(Competition pojo){
        return competitionMapper.insertSelective(pojo);
    }

    @Transactional(rollbackFor = Exception.class)
    public int insertList(List<Competition> pojos){
        return competitionMapper.insertList(pojos);
    }

    @Transactional(rollbackFor = Exception.class)
    public int update(Competition pojo){
        return competitionMapper.update(pojo);
    }

    @Override
    public Competition getCompetition(Map<String, Object> param) {
        return competitionMapper.getCompetition(param);
    }
}
