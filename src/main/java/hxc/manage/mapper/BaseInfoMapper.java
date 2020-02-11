package hxc.manage.mapper;

import hxc.manage.model.Office;
import hxc.manage.model.Performance;
import hxc.manage.model.UserDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface BaseInfoMapper {


    int changeInfo(@Param("map") Map<String, String> map);

    UserDetail userInfo(@Param("id") Long id);

    List<Office> getOffices();

    List<Performance> getPerformanceByUserId(@Param("map") Map<String, Object> map);
}
