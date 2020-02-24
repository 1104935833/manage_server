package hxc.manage.service.impl.table;

import hxc.manage.service.table.TextBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import hxc.manage.model.table.TextBook;
import hxc.manage.mapper.TextBookMapper;

@Service
public class TextBookServiceImpl implements TextBookService {

    @Autowired
    private TextBookMapper textBookMapper;

    public int insert(TextBook pojo){
        return textBookMapper.insert(pojo);
    }

    public int insertSelective(TextBook pojo){
        return textBookMapper.insertSelective(pojo);
    }

    public int insertList(List<TextBook> pojos){
        return textBookMapper.insertList(pojos);
    }

    public int update(TextBook pojo){
        return textBookMapper.update(pojo);
    }
}
