package hxc.manage.service;

import hxc.manage.model.table.Paper;

import java.util.List;

public interface PaperService {

    int insert(Paper pojo);

    int insertSelective(Paper pojo);

    int insertList(List<Paper> pojos);

    int update(Paper pojo);

}
