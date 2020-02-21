package hxc.manage.service.impl;

import hxc.manage.service.ProductionUnionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import hxc.manage.model.table.ProductionUnion;
import hxc.manage.mapper.ProductionUnionMapper;

@Service
public class ProductionUnionServiceImpl implements ProductionUnionService {

    @Autowired
    private ProductionUnionMapper productionUnionMapper;

    public int insert(ProductionUnion pojo){
        return productionUnionMapper.insert(pojo);
    }

    public int insertSelective(ProductionUnion pojo){
        return productionUnionMapper.insertSelective(pojo);
    }

    public int insertList(List<ProductionUnion> pojos){
        return productionUnionMapper.insertList(pojos);
    }

    public int update(ProductionUnion pojo){
        return productionUnionMapper.update(pojo);
    }
}