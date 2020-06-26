package hxc.manage.service.impl;

import hxc.manage.model.Audit;
import hxc.manage.model.RespBean;
import hxc.manage.model.User;
import hxc.manage.service.AuditService;
import hxc.manage.service.PeddingService;
import hxc.manage.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

import hxc.manage.model.Table;
import hxc.manage.mapper.TableMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class TableServiceImpl implements TableService {

    @Autowired
    private TableMapper tableMapper;

    @Autowired
    PeddingService peddingService;

    @Autowired
    AuditService auditService;

    @Transactional(rollbackFor = Exception.class)
    public int insert(Table pojo){
        return tableMapper.insert(pojo);
    }

    /**
     * 新建表格
     * 1.table插入
     * 2.audit插入
     * 3.pedding插入
     * @param request
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public int table(HttpServletRequest request,String user_id, String tableName,int state){
        Table tab = new Table();
        tab.setUserId(Integer.valueOf(user_id));
        tab.setTableName(tableName);
        tab.setState(state);
        insert(tab);//table插入
        peddingService.sendPedding(request,tab.getId().toString(),"1","","1");//pedding插入
        Audit audit = new Audit();
        audit.setProposerId(Integer.valueOf(user_id));
        audit.setProposerType(state);
        audit.setProposerTime(new Date().getTime()+"");
        audit.setTableId(tab.getId());
        audit.setAuditStatus(0);
        auditService.insert(audit);//audit插入
        return tab.getId();
    }

}
