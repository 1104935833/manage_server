package hxc.manage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface CommonMapper {

    List<Map<String, Object>> findOption(@Param("option") String option, @Param("title") String title, @Param("value") String value,@Param("id") String id);

    String getUserRole(@Param("user_id") String user_id);
}
