package hxc.manage.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * @author hxc
 * @version 1.0
 * @date 2019/12/24 13:38
 * 文件上传的公共方法
 */
@Service
public class FileUpLoad {

    //从yml获取路径
    @Value("${url.fileUrlForMac}")
    private String path;


    //文件上传
    public void imageService(MultipartFile file, String fileName, String filePath){
        FileOutputStream out = null;
        try {
            byte[] bytes = file.getBytes();
            String url = path + filePath + "/" + fileName;//文件路劲
            File newFile = new File(url);
            //判断文件父目录是否存在
            if(!newFile.getParentFile().exists()){
                newFile.getParentFile().mkdirs();
            }
            out = new FileOutputStream(newFile);
            out.write(bytes);
            out.flush();
            } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    //删除文件
    public void delFiles(String path){
        try {

            File file = new File(path);
            file.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
