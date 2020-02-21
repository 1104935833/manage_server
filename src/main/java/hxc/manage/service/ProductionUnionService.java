package hxc.manage.service;

import hxc.manage.model.table.ProductionUnion;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProductionUnionService {

   int insert(ProductionUnion pojo);

   int insertSelective(ProductionUnion pojo);

   int insertList(List<ProductionUnion> pojos);

   int update(ProductionUnion pojo);

   List<Map<String,Object>> getProductionUnions(Map param);
}
