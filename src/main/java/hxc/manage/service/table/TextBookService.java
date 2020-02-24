package hxc.manage.service.table;

import hxc.manage.model.table.TextBook;

import java.util.List;

public interface TextBookService {

    int insert(TextBook pojo);

    int insertSelective(TextBook pojo);

    int insertList(List<TextBook> pojos);

    int update(TextBook pojo);
}
