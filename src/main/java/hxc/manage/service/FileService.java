package hxc.manage.service;

import hxc.manage.model.File;

import java.util.List;

public interface FileService {

    int insert(File pojo);

    int insertSelective(File pojo);

    int insertList(List<File> pojo);

    int update(File pojo);

    void delFile(Integer fileId);

    File getFileById(String id);
}
