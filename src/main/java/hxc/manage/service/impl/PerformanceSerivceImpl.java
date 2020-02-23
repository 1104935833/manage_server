package hxc.manage.service.impl;

import hxc.manage.common.DateConverter;
import hxc.manage.mapper.PerformanceMapper;
import hxc.manage.model.File;
import hxc.manage.model.Table;
import hxc.manage.service.FileService;
import hxc.manage.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PerformanceSerivceImpl implements PerformanceService {

    @Autowired
    PerformanceMapper performanceMapper;

    @Autowired
    FileService fileService;

    @Override
    public List<Map<String,Object>> getPerformanceByUserId(Map<String, Object> map) {
        DateConverter dateConverter = new DateConverter();
        List<Map<String,Object>> m = new ArrayList<>();
        List<Table> tables = performanceMapper.getTableByUserId(String.valueOf(map.get("id")),Integer.valueOf(map.get("start")+""),Integer.valueOf(map.get("size")+""));
        for (Table table:tables){
            map.put("tableName",table.getTableName());
            map.put("userId",table.getUserId());
             m= performanceMapper.getPerformanceByUserId(map);
        }
        for (Map<String,Object> l: m) {
            if(!l.containsKey("file_id")){
                l.put("file_id",null);
            }else{
                File file = fileService.getFileById(String.valueOf(l.get("file_id")));
                l.put("file_id",file.getFilePath()+file.getFileName());
            }

            switch (l.get("audit_status").toString()){
                case "0": l.put("audit_status","待审核");break;
                case "1": l.put("audit_status","教研室通过");break;
                case "2": l.put("audit_status","教研室不通过");break;
                case "3": l.put("audit_status","分院通过");break;
                case "4": l.put("audit_status","分院不通过");break;
            }
            l.put("create_time",dateConverter.stampToDate(l.get("create_time")+""));
            l.put("time",dateConverter.stampToDate(l.get("time")+""));
        }

        return m;
    }
}
