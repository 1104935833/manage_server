package hxc.manage.service.impl;

import hxc.manage.mapper.TestMapper;
import hxc.manage.model.DataList;
import hxc.manage.model.Paper;
import hxc.manage.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hxc
 * @version 1.0
 * @date 2019/12/25 9:39
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    TestMapper testMapper;

    @Override
    public Map<String, List> findList() {
        List<DataList> list=testMapper.findList();
        Map<String, List> map = new HashMap<>();
        List<Map<String,String>> publicationType = new ArrayList<>();
        List<Map<String,String>> paperGrades = new ArrayList<>();
        List<Map<String,String>> paperCompanys = new ArrayList<>();
        List<Map<String,String>> subjects = new ArrayList<>();
        List<Map<String,String>> sources = new ArrayList<>();
        List<Map<String,String>> scopes = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Map<String,String> m = new HashMap<>();
            if (list.get(i).getTitle().equals("publication_type")){
                m.put("value",list.get(i).getValue());
                m.put("label",list.get(i).getLabel());
                publicationType.add(m);

            }
            else if (list.get(i).getTitle().equals("paperGrades")){
                m.put("value",list.get(i).getValue());
                m.put("label",list.get(i).getLabel());
                paperGrades.add(m);

            }
            else if (list.get(i).getTitle().equals("paperCompanys")){
                m.put("value",list.get(i).getValue());
                m.put("label",list.get(i).getLabel());
                paperCompanys.add(m);

            }
            else if (list.get(i).getTitle().equals("subjects")){
                m.put("value",list.get(i).getValue());
                m.put("label",list.get(i).getLabel());
                subjects.add(m);

            }
            else if (list.get(i).getTitle().equals("sources")){
                m.put("value",list.get(i).getValue());
                m.put("label",list.get(i).getLabel());
                sources.add(m);

            }
            else if (list.get(i).getTitle().equals("scopes")){
                m.put("value",list.get(i).getValue());
                m.put("label",list.get(i).getLabel());
                scopes.add(m);

            }
            map.put("publication_type",publicationType);
            map.put("paperGrades",paperGrades);
            map.put("paperCompanys",paperCompanys);
            map.put("subjects",subjects);
            map.put("sources",sources);
            map.put("scopes",scopes);
        }

        return map;
    }

    @Override
    public void insetPaper(Paper paper) {
        testMapper.insetPaper(paper);
    }

    @Override
    public String update(Paper paper) {
        testMapper.update(paper);
        return null;
    }




}
