package hxc.manage.controller;

import hxc.manage.model.Honer;
import hxc.manage.model.RespBean;
import hxc.manage.service.HonerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HonerController {

    @Autowired
    HonerService honerService;

    @PostMapping("/insertHoner")
    public RespBean insertHoner(Honer honer) {
        try{
            honerService.insert(honer);
            return RespBean.ok("提交成功");
        }catch (Exception e){
            e.printStackTrace();
            return RespBean.error("提交失败");
        }
    }

    @GetMapping("/searchAllHoner")
    public List<Map<String, Object>> searchHoner(){
        List<Map<String,Object>> honerList = new ArrayList<Map<String,Object>>();
        honerList = honerService.searchAllHoner();
//        List<Map<String,String>> returnList = new ArrayList<Map<String,String>>();
//        Map<String,String> map = new HashMap<String, String>();
        String s1;
        String s2;//应该有问题，但我太菜了
        for(Map<String,Object> m : honerList){
            s1 = honerService.getLabel((int)m.get("personalHonorType"));
            s2 = honerService.getLabel((int)m.get("personalHonorName"));
            m.put("personalHonorType",s1);
            m.put("personalHonorName",s2);
        }
        return honerList;
    }

}
