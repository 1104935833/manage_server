package hxc.manage.service;

import hxc.manage.model.Table;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface TableService {

    int insert(Table pojo);

    void table(HttpServletRequest request, String user_id, String tableId, String tableName, int state);

}
