package hxc.manage.service;

import hxc.manage.model.table.Academic;

import java.util.List;
import java.util.Map;

public interface AcademicService {

   int insert(Academic pojo);

   int insertSelective(Academic pojo);

   int insertList(List<Academic> pojos);

   int update(Academic pojo);

   List<Map<String,Object>> getAcademics(Map param);
}
