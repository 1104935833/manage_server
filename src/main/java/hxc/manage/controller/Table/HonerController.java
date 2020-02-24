package hxc.manage.controller.Table;

import hxc.manage.model.table.Honer;
import hxc.manage.model.RespBean;
import hxc.manage.service.table.HonerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public Map<String, Object> searchHoner(@RequestParam(required = false) Map param){
        List<Map<String,Object>> res = honerService.searchHoner(param);
        Map<String,Object> map = new HashMap<>();
        map.put("res",res);
        return map;
    }

}
