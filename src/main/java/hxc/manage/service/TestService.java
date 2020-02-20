package hxc.manage.service;

import hxc.manage.model.table.Paper;

import java.util.List;
import java.util.Map;

/**
 * @author hxc
 * @version 1.0
 * @date 2019/12/25 9:35
 */
public interface TestService {

    Map<String, List> findList();


    void insetPaper(Paper paper);


    String update(Paper paper);


}
