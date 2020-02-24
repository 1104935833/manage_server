package hxc.manage.service.table;

import hxc.manage.model.table.TextBook;

import java.util.List;
import java.util.Map;

public interface TextBookService {

    int insert(TextBook pojo);

    int insertSelective(TextBook pojo);

    int insertList(List<TextBook> pojos);

    int update(TextBook pojo);

    TextBook getTextBook(Map<String,Object> param);
}
