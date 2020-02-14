package hxc.manage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import hxc.manage.model.Table;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface TableMapper {

    int insert(@Param("pojo") Table pojo);

    int insertSelective(@Param("pojo") Table pojo);

    int insertList(@Param("pojos") List<Table> pojo);

    int update(@Param("pojo") Table pojo);
}
