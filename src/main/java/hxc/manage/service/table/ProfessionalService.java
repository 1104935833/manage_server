package hxc.manage.service.table;

import hxc.manage.model.table.Professional;

import java.util.List;

public interface ProfessionalService {

    int insert(Professional pojo);

    int insertSelective(Professional pojo);

    int insertList(List<Professional> pojos);

    int update(Professional pojo);
}
