package hxc.manage.service.impl;

import hxc.manage.mapper.FileMapper;
import hxc.manage.model.File;
import hxc.manage.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    FileMapper fileMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(File pojo) {
        return fileMapper.insert(pojo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertSelective(File pojo) {
        return fileMapper.insert(pojo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertList(List<File> pojo) {
        return fileMapper.insertList(pojo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int update(File pojo) {
        return fileMapper.update(pojo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delFile(Integer fileId) {
        fileMapper.delFile(fileId);
    }

    @Override
    public File getFileById(String id) {
        return fileMapper.getFileById(id);
    }
}
