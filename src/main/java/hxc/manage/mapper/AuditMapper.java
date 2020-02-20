package hxc.manage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

import hxc.manage.model.Audit;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface AuditMapper {

    int insert(@Param("pojo") Audit pojo);

    int insertSelective(@Param("pojo") Audit pojo);

    int insertList(@Param("pojos") List<Audit> pojo);

    int update(@Param("pojo") Audit pojo);

    List<Map<String, Object>> getAllAudit(@Param("conditions") Map<String, Object> conditions);

    int updateAuit(@Param("pojo")Map<String, Object> conditions);

    String getTableName(String tableId);
}
