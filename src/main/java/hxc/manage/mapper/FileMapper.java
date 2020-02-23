package hxc.manage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import hxc.manage.model.File;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface FileMapper {
    int insert(@Param("pojo") File pojo);

    int insertSelective(@Param("pojo") File pojo);

    int insertList(@Param("pojos") List<File> pojo);

    int update(@Param("pojo") File pojo);

    void delFile(Integer fileId);

    File getFileById(String id);
}
