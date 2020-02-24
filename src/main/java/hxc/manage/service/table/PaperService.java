package hxc.manage.service.table;

import hxc.manage.model.table.Paper;

import java.util.List;
import java.util.Map;

public interface PaperService {

    int insert(Paper pojo);

    int insertSelective(Paper pojo);

    int insertList(List<Paper> pojos);

    int update(Paper pojo);

    Paper getPaper(Map<String,Object> param);
}
