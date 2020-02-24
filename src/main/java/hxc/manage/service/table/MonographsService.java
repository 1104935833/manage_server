package hxc.manage.service.table;

import hxc.manage.model.table.Monographs;

import java.util.List;

public interface MonographsService {

    int insert(Monographs pojo);

    int insertSelective(Monographs pojo);

    int insertList(List<Monographs> pojos);

    int update(Monographs pojo);
}
