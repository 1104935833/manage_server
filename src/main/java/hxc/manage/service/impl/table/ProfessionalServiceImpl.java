package hxc.manage.service.impl.table;

import hxc.manage.service.table.ProfessionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import hxc.manage.model.table.Professional;
import hxc.manage.mapper.ProfessionalMapper;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProfessionalServiceImpl implements ProfessionalService {

    @Autowired
    private ProfessionalMapper professionalMapper;

    @Transactional(rollbackFor = Exception.class)
    public int insert(Professional pojo){
        return professionalMapper.insert(pojo);
    }

    @Transactional(rollbackFor = Exception.class)
    public int insertSelective(Professional pojo){
        return professionalMapper.insertSelective(pojo);
    }

    @Transactional(rollbackFor = Exception.class)
    public int insertList(List<Professional> pojos){
        return professionalMapper.insertList(pojos);
    }

    @Transactional(rollbackFor = Exception.class)
    public int update(Professional pojo){
        return professionalMapper.update(pojo);
    }

    @Override
    public Professional getProfessional(Map<String, Object> param) {
        return professionalMapper.getProfessional(param);
    }
}
