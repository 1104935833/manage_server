package hxc.manage.service.impl.table;

import hxc.manage.service.table.TextBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import hxc.manage.model.table.TextBook;
import hxc.manage.mapper.TextBookMapper;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TextBookServiceImpl implements TextBookService {

    @Autowired
    private TextBookMapper textBookMapper;

    @Transactional(rollbackFor = Exception.class)
    public int insert(TextBook pojo){
        return textBookMapper.insert(pojo);
    }

    @Transactional(rollbackFor = Exception.class)
    public int insertSelective(TextBook pojo){
        return textBookMapper.insertSelective(pojo);
    }

    @Transactional(rollbackFor = Exception.class)
    public int insertList(List<TextBook> pojos){
        return textBookMapper.insertList(pojos);
    }

    @Transactional(rollbackFor = Exception.class)
    public int update(TextBook pojo){
        return textBookMapper.update(pojo);
    }

    @Override
    public TextBook getTextBook(Map<String, Object> param) {
        return textBookMapper.getTextBook(param);
    }
}
