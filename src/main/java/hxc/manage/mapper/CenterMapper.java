package hxc.manage.mapper;

import hxc.manage.model.UserDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface CenterMapper {

    void editPwd(@Param("yzm") String yzm, @Param("newPwd") String newPwd, @Param("id") Long id);


    List<Map<String, Object>> getPerforEcharts(@Param("user_id") String user_id, @Param("year") int year);

    List<Map<String, Object>> getPerforEcharts1(@Param("id") String id );

    List<Map<String, Object>> getPerformance(@Param("id") String id,@Param("state1") String state1,@Param("state2") String state2 );
}
