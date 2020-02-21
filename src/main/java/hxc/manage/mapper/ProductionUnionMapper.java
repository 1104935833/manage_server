package hxc.manage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import hxc.manage.model.table.ProductionUnion;

@Mapper
public interface ProductionUnionMapper {
    int insert(@Param("pojo") ProductionUnion pojo);

    int insertSelective(@Param("pojo") ProductionUnion pojo);

    int insertList(@Param("pojos") List<ProductionUnion> pojo);

    int update(@Param("pojo") ProductionUnion pojo);
}