package hxc.manage.service;

import hxc.manage.model.table.Monographs;

import java.util.List;
import java.util.Map;

public interface MonographsService {

    int insert(Monographs pojo);

    int insertSelective(Monographs pojo);

    int insertList(List<Monographs> pojos);

    int update(Monographs pojo);

    List<Map<String, Object>> getMonographs(Map param);
}
