package org.sang.controller;

import org.sang.bean.Paper;
import org.sang.common.DateConverter;
import org.sang.common.FileUpLoad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    FileUpLoad fileUpLoad;

    @PostMapping("/data")
    public String test(Paper paper){
        System.out.println(paper.toString());
        return "1";
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

    @GetMapping("/dd")
    public String d(){
        return "hello world!";
    }


}
