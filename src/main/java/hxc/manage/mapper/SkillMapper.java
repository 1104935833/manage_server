package hxc.manage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import hxc.manage.model.table.Skill;

@Mapper
public interface SkillMapper {
    int insert(@Param("pojo") Skill pojo);

    int insertSelective(@Param("pojo") Skill pojo);

    int insertList(@Param("pojos") List<Skill> pojo);

    int update(@Param("pojo") Skill pojo);
}
