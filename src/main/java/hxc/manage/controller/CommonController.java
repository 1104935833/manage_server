package hxc.manage.controller;


import hxc.manage.common.FileUpLoad;
import hxc.manage.common.JwtTokenProvider;
import hxc.manage.model.File;
import hxc.manage.model.RespBean;
import hxc.manage.model.User;
import hxc.manage.service.CommonService;
import hxc.manage.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/common")
public class CommonController {

    @Value("${url.fileUrl}")
    private String fileUrl;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    CommonService commonService;

    @Autowired
    FileService fileService;

    @Autowired
    FileUpLoad fileUpLoad;

    @GetMapping("/getUserRole")
    public RespBean getUserRole(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        User u = jwtTokenProvider.getUserFromToken(token);
        String map = commonService.getUserRole(u.getUser_id());
        return RespBean.ok("success", map);
    }

    @GetMapping("/getFileNameById")
    public RespBean getFileNameById(@RequestParam("id") String id) {
        File res = fileService.getFileById(id);
        Map<String, Object> map = new HashMap<>();
        map.put("file", res);
        return RespBean.ok("success", map);

    }

    @GetMapping("/getOption")
    public RespBean option(@RequestParam("option") String option, @RequestParam("title") String title, @RequestParam("value") String value,@RequestParam(name = "id",defaultValue = "",required = false) String id) {
        List<Map<String, Object>> res = commonService.findOption(option, title, value, id);
        Map<String, Object> map = new HashMap<>();
        map.put("options", res);
        return RespBean.ok("success", map);

    }

    //文件上传
    @PostMapping("/file")
    public RespBean file(MultipartFile file, HttpServletRequest request) {
        try {
            String name = "u_" + System.currentTimeMillis() + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            String path = "/upOradd";
            long fileSize = file.getSize(); //文件大小
            String url = fileUrl + path + "/";//文件路劲
            String suffix = name.substring(name.lastIndexOf(".") + 1);//文件后缀
            fileUpLoad.imageService(file, name, path);
            //插入数据库
            String token = request.getHeader("Authorization");
            User u = jwtTokenProvider.getUserFromToken(token);
            File newFile = new File();
            newFile.setFileName(name);
            newFile.setFilePath(url);
            newFile.setFileExt(suffix);
            newFile.setFileSize(fileSize);
            newFile.setCreateTime(String.valueOf(new Date().getTime()));
            newFile.setUserId(u.getId().intValue());
            fileService.insert(newFile);
            Map<String, String> map = new HashMap<>();
            map.put("fileName", name);
            map.put("fileId", String.valueOf(newFile.getId()));
            return RespBean.ok("上传成功", map);
        } catch (Exception e) {
            e.printStackTrace();
            return RespBean.error("上传失败");
        }


    }

    //文件删除
    @GetMapping("/delFile")
    public RespBean delFile(@RequestParam("fileName") String fileName, @RequestParam("fileId") String fileId) {
        System.out.println(fileName + fileId);
        try {
            fileUpLoad.delFiles(fileUrl + "upOradd\\" + fileName);
            //删除
            fileService.delFile(Integer.valueOf(fileId));


            return RespBean.ok("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return RespBean.error("删除失败");
        }

    }


}
