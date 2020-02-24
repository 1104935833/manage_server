package hxc.manage.service.table;

import hxc.manage.model.table.Skill;

import java.util.List;

public interface SkillService {

    int insert(Skill pojo);

    int insertSelective(Skill pojo);

    int insertList(List<Skill> pojos);

    int update(Skill pojo);
}
