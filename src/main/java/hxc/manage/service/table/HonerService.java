package hxc.manage.service.table;

import hxc.manage.model.table.Honer;

import java.util.List;
import java.util.Map;

public interface HonerService {

   int insert(Honer pojo);

   int insertSelective(Honer pojo);

   int insertList(List<Honer> pojos);

   int update(Honer pojo);

   List<Map<String, Object>> searchHoner(Map param);
}
