package hxc.manage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

import hxc.manage.model.table.Competition;

@Mapper
public interface CompetitionMapper {
    int insert(@Param("pojo") Competition pojo);

    int insertSelective(@Param("pojo") Competition pojo);

    int insertList(@Param("pojos") List<Competition> pojo);

    int update(@Param("pojo") Competition pojo);

    Competition getCompetition(@Param("pojo") Map<String, Object> param);

}
