package hxc.manage.controller;


import hxc.manage.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/common")
public class CommonController {

    @Autowired
    CommonService commonService;


    @GetMapping("/getOption")
    public Map<String,Object> option(@RequestParam("option") String option, @RequestParam("title") String title, @RequestParam("value") String value){
        List<Map<String,Object>> res = commonService.findOption(option,title,value);
        Map<String,Object> map = new HashMap<>();
        map.put("options",res);
        return map;

    }

}
