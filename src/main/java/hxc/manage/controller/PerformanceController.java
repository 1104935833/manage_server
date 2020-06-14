package hxc.manage.controller;

import com.alibaba.druid.util.StringUtils;
import hxc.manage.common.DateConverter;
import hxc.manage.common.JwtTokenProvider;
import hxc.manage.model.Performance;
import hxc.manage.model.RespBean;
import hxc.manage.model.User;
import hxc.manage.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class PerformanceController {

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    PerformanceService performanceService;

    @PostMapping("/serchPerformance")
    public Map<String,Object> serchPerformance(@RequestBody Map info, HttpServletRequest request){
        DateConverter dateConverter = new DateConverter();
        String token = request.getHeader("Authorization");
        User u =jwtTokenProvider.getUserFromToken(token);
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
        String token = request.getHeader("Authorization");
        User u =jwtTokenProvider.getUserFromToken(token);
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
    public RespBean getperType(@RequestParam("state") String state){
        List list = performanceService.getperType(state);
        return RespBean.ok("success",list);
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
    public RespBean searchPer(@RequestBody Map form) throws ParseException {
        DateConverter dateConverter = new DateConverter();
        Map<String,Object> map = (Map<String, Object>) form.get("resform");
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
        List<Map<String,Object>> listWithoutDuplicates = m.stream().distinct().collect(Collectors.toList());
        Map<String,Object> res = new HashMap<>();
        res.put("res",listWithoutDuplicates);
        res.put("count",listWithoutDuplicates.size());
        return RespBean.ok("success",res);
    }


}
