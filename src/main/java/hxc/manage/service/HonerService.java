package hxc.manage.service;

import hxc.manage.model.Honer;

import java.util.List;

public interface HonerService {

   int insert(Honer pojo);

   int insertSelective(Honer pojo);

   int insertList(List<Honer> pojos);

   int update(Honer pojo);

}
