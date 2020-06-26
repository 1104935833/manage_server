package hxc.manage.service.impl.table;

import hxc.manage.service.table.ProductionUnionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import hxc.manage.model.table.ProductionUnion;
import hxc.manage.mapper.ProductionUnionMapper;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductionUnionServiceImpl implements ProductionUnionService {

    @Autowired
    private ProductionUnionMapper productionUnionMapper;

    @Transactional(rollbackFor = Exception.class)
    public int insert(ProductionUnion pojo){
        return productionUnionMapper.insert(pojo);
    }

    @Transactional(rollbackFor = Exception.class)
    public int insertSelective(ProductionUnion pojo){
        return productionUnionMapper.insertSelective(pojo);
    }

    @Transactional(rollbackFor = Exception.class)
    public int insertList(List<ProductionUnion> pojos){
        return productionUnionMapper.insertList(pojos);
    }

    @Transactional(rollbackFor = Exception.class)
    public int update(ProductionUnion pojo){
        return productionUnionMapper.update(pojo);
    }

    @Override
    public ProductionUnion getProductionUnion(Map<String, Object> param) {
        return productionUnionMapper.getProductionUnion(param);
    }
}
