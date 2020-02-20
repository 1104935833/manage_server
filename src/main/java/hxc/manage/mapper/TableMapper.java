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

}
