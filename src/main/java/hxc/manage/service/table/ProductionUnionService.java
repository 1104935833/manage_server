package hxc.manage.service.table;

import hxc.manage.model.table.ProductionUnion;

import java.util.List;
import java.util.Map;

public interface ProductionUnionService {

    int insert(ProductionUnion pojo);

    int insertSelective(ProductionUnion pojo);

    int insertList(List<ProductionUnion> pojos);

    int update(ProductionUnion pojo);

    ProductionUnion getProductionUnion(Map<String,Object> param);
}
