package hxc.manage.service.impl;

import hxc.manage.mapper.FileMapper;
import hxc.manage.model.File;
import hxc.manage.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    FileMapper fileMapper;

    @Override
    public int insert(File pojo) {
        return fileMapper.insert(pojo);
    }

    @Override
    public int insertSelective(File pojo) {
        return fileMapper.insert(pojo);
    }

    @Override
    public int insertList(List<File> pojo) {
        return fileMapper.insertList(pojo);
    }

    @Override
    public int update(File pojo) {
        return fileMapper.update(pojo);
    }
}
