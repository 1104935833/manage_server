package hxc.manage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

import hxc.manage.model.Honer;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface HonerMapper {
    int insert(@Param("pojo") Honer pojo);

    int insertSelective(@Param("pojo") Honer pojo);

    int insertList(@Param("pojos") List<Honer> pojo);

    int update(@Param("pojo") Honer pojo);

    List<Map<String,Object>> searchAllHoner();

    String getLabel(int id);
}
