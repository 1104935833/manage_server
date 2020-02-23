package hxc.manage.controller;

import hxc.manage.common.DateConverter;
import hxc.manage.model.Performance;
import hxc.manage.model.User;
import hxc.manage.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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


}
