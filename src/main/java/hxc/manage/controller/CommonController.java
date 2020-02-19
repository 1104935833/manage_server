package hxc.manage.controller;


import hxc.manage.common.FileUpLoad;
import hxc.manage.model.RespBean;
import hxc.manage.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/common")
public class CommonController {

    @Value("${url.fileUrl}")
    private String fileUrl;

    @Autowired
    CommonService commonService;


    @Autowired
    FileUpLoad fileUpLoad;

    @GetMapping("/getOption")
    public Map<String,Object> option(@RequestParam("option") String option, @RequestParam("title") String title, @RequestParam("value") String value){
        List<Map<String,Object>> res = commonService.findOption(option,title,value);
        Map<String,Object> map = new HashMap<>();
        map.put("options",res);
        return map;

    }

    //文件上传
    @PostMapping("/file")
    public RespBean file(MultipartFile file){
        try {
            String name = "u_" + System.currentTimeMillis() + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            String path = "/upOradd/";
            long fileSize = file.getSize(); //文件大小
            String url = fileUrl + path + "/" + path;//文件路劲
            String suffix = name.substring(name.lastIndexOf(".") + 1);//文件后缀
            fileUpLoad.imageService(file, name, path);
            //插入数据库




            return RespBean.ok("上传成功");
        }catch (Exception e){
            e.printStackTrace();
            return RespBean.error("上传失败");
        }


    }

    //文件删除
    @GetMapping("/delFile")
    public RespBean delFile(@RequestParam("fileName") String fileName){
        System.out.println(fileName);
        try{
            fileUpLoad.delFiles(fileUrl+"upOradd\\"+fileName);
            //删除




            return RespBean.ok("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return RespBean.error("删除失败");
        }

    }



}
