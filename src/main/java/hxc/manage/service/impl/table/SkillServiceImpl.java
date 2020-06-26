package hxc.manage.service.impl.table;

import hxc.manage.service.table.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import hxc.manage.model.table.Skill;
import hxc.manage.mapper.SkillMapper;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillMapper skillMapper;

    @Transactional(rollbackFor = Exception.class)
    public int insert(Skill pojo){
        return skillMapper.insert(pojo);
    }

    @Transactional(rollbackFor = Exception.class)
    public int insertSelective(Skill pojo){
        return skillMapper.insertSelective(pojo);
    }

    @Transactional(rollbackFor = Exception.class)
    public int insertList(List<Skill> pojos){
        return skillMapper.insertList(pojos);
    }

    @Transactional(rollbackFor = Exception.class)
    public int update(Skill pojo){
        return skillMapper.update(pojo);
    }

    @Override
    public Skill getSkill(Map<String, Object> param) {
        return skillMapper.getSkill(param);
    }
}
