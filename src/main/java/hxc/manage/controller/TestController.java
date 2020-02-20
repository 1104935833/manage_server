package hxc.manage.controller;

import hxc.manage.common.poi.PoiUtils;
import hxc.manage.model.table.Paper;
import hxc.manage.model.RespBean;
import hxc.manage.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author hxc
 * @version 1.0
 * @date 2019/12/24 9:28
 */
@RestController
@RequestMapping("/test")
public class TestController {


    @Autowired
    TestService testService;






    @PostMapping("/data")
    public Object test(Paper paper){
        try {
            testService.insetPaper(paper);
            return RespBean.ok("success");
        }catch(Exception e){
            e.printStackTrace();
            return RespBean.error("error");
        }

    }




    @GetMapping("/dataList")
    public Map<String, List> d(){
        Map<String, List> l= testService.findList();
        return l;
    }

    @GetMapping("/update")
    public String update(Paper paper){
        testService.update(paper);
        return "";
    }

    @GetMapping("/template")
    public ResponseEntity<byte[]> template(){

        return PoiUtils.template();

    }

}
