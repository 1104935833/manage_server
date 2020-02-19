package hxc.manage.model;

import lombok.Data;

@Data
public class File {

   private Integer id;

   private String fileName;

   private String filePath;

   private String fileExt;

   private Long fileSize;

   private String createTime;

   private Integer userId;

}
