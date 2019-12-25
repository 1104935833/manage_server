package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.sang.bean.DataList;
import org.sang.bean.Paper;
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
}
