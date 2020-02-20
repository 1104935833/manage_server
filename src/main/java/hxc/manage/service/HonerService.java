package hxc.manage.service;

import hxc.manage.model.Honer;

import java.util.List;
import java.util.Map;

public interface HonerService {

   int insert(Honer pojo);

   int insertSelective(Honer pojo);

   int insertList(List<Honer> pojos);

   int update(Honer pojo);

   List<Map<String, Object>> searchAllHoner();

}
