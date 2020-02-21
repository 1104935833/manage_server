package hxc.manage.service;

import hxc.manage.model.table.Paper;

import java.util.List;
import java.util.Map;

public interface PaperService {

    int insert(Paper pojo);

    int insertSelective(Paper pojo);

    int insertList(List<Paper> pojos);

    int update(Paper pojo);

    Paper getPaper(Map param);
}
