package hxc.manage.mapper;

import org.apache.ibatis.annotations.Mapper;
import hxc.manage.model.DataList;
import hxc.manage.model.table.Paper;
import org.springframework.stereotype.Component;


import java.util.List;

/**
 * @author hxc
 * @version 1.0
 * @date 2019/12/25 9:40
 */
@Mapper
@Component
public interface TestMapper {

    List<DataList> findList();

    void insetPaper(Paper paper);

    String update(Paper paper);


}
