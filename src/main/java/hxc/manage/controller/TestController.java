package hxc.manage.controller;

import hxc.manage.common.FileUpLoad;
import hxc.manage.common.poi.PoiUtils;
import hxc.manage.model.Paper;
import hxc.manage.model.RespBean;
import hxc.manage.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @Value("${url.fileUrl}")
    private String path;

    @Autowired
    TestService testService;

    @Autowired
    FileUpLoad fileUpLoad;

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

    @PostMapping("/file")
    public String file(MultipartFile file){
        String  name = "u_"+System.currentTimeMillis()+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String path = "/upOradd/";
        fileUpLoad.imageService(file,name,path);
        return name;
    }

    @GetMapping("/delFile")
    public String delFile(@RequestParam("fileName") String fileName){
        System.out.println(fileName);
        try{
            fileUpLoad.delFiles(path+"upOradd\\"+fileName);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "success";
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
