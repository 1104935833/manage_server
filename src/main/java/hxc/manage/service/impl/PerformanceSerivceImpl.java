package hxc.manage.service.impl;

import com.alibaba.druid.util.StringUtils;
import hxc.manage.common.DateConverter;
import hxc.manage.mapper.*;
import hxc.manage.model.File;
import hxc.manage.model.Table;
import hxc.manage.service.FileService;
import hxc.manage.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PerformanceSerivceImpl implements PerformanceService {

    @Autowired
    PerformanceMapper performanceMapper;

    @Autowired
    PaperMapper paperMapper;

    @Autowired
    FileService fileService;

    @Autowired
    MonographsMapper monographsMapper;
    @Autowired
    PatentMapper patentMapper;
    @Autowired
    PortraitMapper portraitMapper;
    @Autowired
    TransverseMapper transverseMapper;
    @Autowired
    FirstSubjectMapper firstSubjectMapper;
    @Autowired
    LabMapper labMapper;
    @Autowired
    TechnologicalMapper technologicalMapper;
    @Autowired
    ProductionUnionMapper productionUnionMapper;
    @Autowired
    AcademicMapper academicMapper;
    @Autowired
    HonerMapper honerMapper;
    @Autowired
    StudentResearchMapper studentResearchMapper;
    @Autowired
    SkillMapper skillMapper;
    @Autowired
    CompetitionMapper competitionMapper;
    @Autowired
    EducationalMapper educationalMapper;
    @Autowired
    AchievementMapper achievementMapper;
    @Autowired
    TeachingReformMapper teachingReformMapper;
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    TextBookMapper textBookMapper;
    @Autowired
    ProfessionalMapper professionalMapper;

    @Override
    public List<Map<String,Object>> getPerformanceByUserId(Map<String, Object> map) {
        DateConverter dateConverter = new DateConverter();
        List<Map<String,Object>> m = new ArrayList<>();
        List<Table> tables = performanceMapper.getTableByUserId(String.valueOf(map.get("id")));
        for (Table table:tables){
            map.put("tableName",table.getTableName());
            map.put("userId",table.getUserId());
            map.put("tableId",table.getId());
            m.addAll(performanceMapper.getPerformanceByUserId(map));
        }
        for (Map<String,Object> l: m) {
            if(!l.containsKey("file_id")){
                l.put("file_id",null);
            }else{
                File file = fileService.getFileById(String.valueOf(l.get("file_id")));
                l.put("file_id",file.getFileName());
            }

            switch (l.get("audit_status").toString()){
                case "0": l.put("audit_status","待审核");break;
                case "1": l.put("audit_status","教研室通过");break;
                case "2": l.put("audit_status","教研室不通过");break;
                case "3": l.put("audit_status","分院通过");break;
                case "4": l.put("audit_status","分院不通过");break;
            }
            l.put("create_time",dateConverter.stampToDate(l.get("create_time")+""));
            if(l.containsKey("time")) {
                l.put("time", dateConverter.stampToDate(l.get("time") + ""));
            }
        }

        return m;
    }

    @Override
    public List<Map<String,Object>> getperType(String state) {
        return performanceMapper.getperType(state,"","");
    }

    @Override
    public List<Map<String, Object>> searchPerNameNotNull(Map<String, Object> map) {
        List<Map<String,Object>> m= new ArrayList<>();
        List<Map<String,Object>>  tables = performanceMapper.getperType("",map.get("option")+"",String.valueOf(map.get("group")));

        for (Map<String,Object> table:tables) {
            map.put("tableName",table.get("name"));
            m.addAll(performanceMapper.searchPerNameNotNull(map));
        }
        return m;
    }

    @Override
    public List<Map<String, Object>> searchPerOther(Map<String, Object> map) {
        DateConverter dateConverter = new DateConverter();
        List<Map<String,Object>> m = new ArrayList<>();
        List<Map<String,Object>> tables;
        Map<String, Object> con = new HashMap<>();

            if (dateConverter.isDate(map.get("data2")+"")){
                try {
                    map.put("data2",dateConverter.date1ToTimeMillis(map.get("data2")+""));
                } catch (ParseException e) {
                }
            }
            if(map.get("keyword")==null && !map.get("option").equals("")) {

                if (Integer.valueOf(map.get("option") + "") < 7 ) {
                    tables = performanceMapper.getperType(map.get("option") + "", "",String.valueOf(map.get("group")));
                } else {
                    tables = performanceMapper.getperType("", map.get("option") + "",String.valueOf(map.get("group")));
                }
                con.putAll(map);
                if (StringUtils.equals(map.get("data1") + "", "") && StringUtils.equals(map.get("data2") + "", "")
                        && StringUtils.equals(map.get("data3") + "", "") && StringUtils.equals(map.get("data4") + "", "") || Integer.valueOf(map.get("option") + "") < 7) {
                    for (Map<String, Object> table : tables) {
                        if (table.get("name")!=null && !table.get("name").equals("")) {
                        con.put("tableName", table.get("name"));
                        con.put("name", map.get("name"));
                        con.put("create_time", map.get("time"));

                        m.addAll(performanceMapper.getPerformanceByUserId(con));
                        }else{
                            continue;
                        }
                    }
                } else {
                    m = other(map);
                }
            }else{
                con.putAll(map);
                tables = performanceMapper.getperType( "", "",String.valueOf(map.get("group")));
                for (Map<String, Object> table : tables) {
                    if (table.get("name")!=null && !table.get("name").equals("")) {
                        con.put("tableName", table.get("name"));
                        con.put("keywords", map.get("keyword"));
                        if (map.get("group")!=null && map.get("group").equals("group") && table.get("name").equals("honor")){
                            con.put("type","g");

                        }else if(map.get("group")!=null && map.get("group").equals("self") && table.get("name").equals("honor")){
                            con.put("type","s");
                        }else{
                            con.remove("type");
                        }
                        m.addAll(performanceMapper.getPerformanceByUserId(con));
                    }else{
                        continue;
                    }
                }
            }

        return m;
    }

    @Override
    public List<Map<String, Object>> getperTypeGroup() {
        return performanceMapper.getperType("","","group");
    }

    @Override
    public List<Map<String, Object>> getperTypeSelf() {
        return performanceMapper.getperType("","","self");
    }


    public  List<Map<String,Object>> other(Map<String,Object> map) {
        List<Map<String,Object>> res = new ArrayList<>();
        switch (String.valueOf(map.get("option"))) {
            case "7": res=paperMapper.getList(map);break;
            case "8": res=monographsMapper.getList(map);break;
            case "9": res=patentMapper.getList(map);break;
            case "10": res=portraitMapper.getList(map);break;
            case "11": res=transverseMapper.getList(map);break;
            case "17": res=firstSubjectMapper.getList(map);break;
            case "18": res=labMapper.getList(map);break;
            case "19": res=technologicalMapper.getList(map);break;
            case "20": res=productionUnionMapper.getList(map);break;
            case "21": res=academicMapper.getList(map);break;
            case "22": res=honerMapper.getList(map);break;
            case "23": res=honerMapper.getList(map);break;
            case "24": res=studentResearchMapper.getList(map);break;
            case "25": res=skillMapper.getList(map);break;
            case "26": res=competitionMapper.getList(map);break;
            case "27": res=educationalMapper.getList(map);break;
            case "28": res=achievementMapper.getList(map);break;
            case "29": res=teachingReformMapper.getList(map);break;
            case "30": res=courseMapper.getList(map);break;
            case "31": res=textBookMapper.getList(map);break;
            case "32": res=professionalMapper.getList(map);break;
        }
        return res;

    }


}
