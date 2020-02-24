package hxc.manage.service.impl.table;

import hxc.manage.service.table.ProfessionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import hxc.manage.model.table.Professional;
import hxc.manage.mapper.ProfessionalMapper;

@Service
public class ProfessionalServiceImpl implements ProfessionalService {

    @Autowired
    private ProfessionalMapper professionalMapper;

    public int insert(Professional pojo){
        return professionalMapper.insert(pojo);
    }

    public int insertSelective(Professional pojo){
        return professionalMapper.insertSelective(pojo);
    }

    public int insertList(List<Professional> pojos){
        return professionalMapper.insertList(pojos);
    }

    public int update(Professional pojo){
        return professionalMapper.update(pojo);
    }
}
