package hxc.manage.controller;

import com.alibaba.druid.util.StringUtils;
import hxc.manage.common.DateConverter;
import hxc.manage.model.Performance;
import hxc.manage.model.User;
import hxc.manage.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PerformanceController {

    @Autowired
    PerformanceService performanceService;

    @PostMapping("/serchPerformance")
    public Map<String,Object> serchPerformance(@RequestBody Map info, HttpServletRequest request){
        DateConverter dateConverter = new DateConverter();
        User u = (User) request.getSession().getAttribute("userinfo");
        Map<String,Object> map = (Map<String, Object>) info.get("info");
        int start = ((int) info.get("page") - 1) *(int) info.get("size");
        String keywords = info.get("keywords")+"";
        if(info.get("time")!=null && info.get("time")!=""){
            List time = (List) info.get("time");
            map.put("starTime", dateConverter.convert(time.get(0)+"").getTime());
            map.put("endTime",dateConverter.convert(time.get(1)+"").getTime());
        }

        map.put("id",u.getId());
        map.put("start",start);
        map.put("keywords",keywords);
        map.put("size",info.get("size"));

        List<Map<String,Object>> performance= performanceService.getPerformanceByUserId(map);
        int count = performance.size();
        Map<String,Object> res= new HashMap<>();
        res.put("count",count);
        res.put("performance",performance);

        return res;

    }

    @GetMapping("/getPerformanceByUserId")
    public Map<String,Object> getPerformanceByUserId(HttpServletRequest request,
                                                     @RequestParam(defaultValue = "1") Integer page,
                                                     @RequestParam(defaultValue = "10") Integer size){
        int start = (page - 1) * size;
        User u = (User) request.getSession().getAttribute("userinfo");
        Map<String,Object> map = new HashMap<>();
        map.put("id",u.getId());
        map.put("size",size);
        map.put("start",start);
        List<Map<String,Object>> performance= performanceService.getPerformanceByUserId(map);
        int count = performance.size();
        Map<String,Object> res= new HashMap<>();
        res.put("count",count);
        res.put("performance",performance);

        return res;
    }

    @GetMapping("/getperType")
    public List<Map<String,Object>> getperType(@RequestParam("state") String state){
        return performanceService.getperType(state);
    }

    @GetMapping("/getperTypeGroup")
    public List<Map<String,Object>> getperTypeGroup(){
        return performanceService.getperTypeGroup();
    }

    @GetMapping("/getperTypeSelf")
    public List<Map<String,Object>> getperTypeSelf(){
        return performanceService.getperTypeSelf();
    }




    @PostMapping("/searchPer")
    public Map<String,Object> searchPer(@RequestBody Map form) throws ParseException {
        DateConverter dateConverter = new DateConverter();
        Map<String,Object> map = (Map<String, Object>) form.get("resform");
        int page = Integer.valueOf(map.get("page")+"");
        int size = Integer.valueOf(map.get("size")+"");
        int start = (page - 1) * size;
        map.put("size",size);
        map.put("start",start);
        if (!StringUtils.equals(map.get("time")+"","")) {
            String[] time = String.valueOf(map.get("time")).split(",");
            map.put("starTime", dateConverter.date1ToTimeMillis(time[0].replaceAll("\\[", "")));
            map.put("endTime", dateConverter.date1ToTimeMillis(time[1].replaceAll("\\]", "")));
        }
        List<Map<String,Object>> m;
        if (map.get("keyword")==null){//keyword为空
            if(!map.get("username").equals("")){//名称不为空  table表
                 m = performanceService.searchPerNameNotNull(map);
            }else{//sql判断类型类型不为空 table_state表
                m = performanceService.searchPerOther(map);
            }
        }else{//keywords不为空去所有表格找 table_state表
            m = performanceService.searchPerOther(map);
        }
        Map<String,Object> res = new HashMap<>();
        res.put("res",m);
        res.put("count",m.size());
        return res;
    }


}
