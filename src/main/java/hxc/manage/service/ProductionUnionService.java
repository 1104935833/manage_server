package hxc.manage.service;

import hxc.manage.model.table.ProductionUnion;

import java.util.List;

public interface ProductionUnionService {

   int insert(ProductionUnion pojo);

   int insertSelective(ProductionUnion pojo);

   int insertList(List<ProductionUnion> pojos);

   int update(ProductionUnion pojo);

}
