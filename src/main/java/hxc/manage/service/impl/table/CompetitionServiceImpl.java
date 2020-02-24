package hxc.manage.service.impl.table;

import hxc.manage.service.CommonService;
import hxc.manage.service.table.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import hxc.manage.model.table.Competition;
import hxc.manage.mapper.CompetitionMapper;

@Service
public class CompetitionServiceImpl implements CompetitionService {

    @Autowired
    private CompetitionMapper competitionMapper;

    public int insert(Competition pojo){
        return competitionMapper.insert(pojo);
    }

    public int insertSelective(Competition pojo){
        return competitionMapper.insertSelective(pojo);
    }

    public int insertList(List<Competition> pojos){
        return competitionMapper.insertList(pojos);
    }

    public int update(Competition pojo){
        return competitionMapper.update(pojo);
    }
}
