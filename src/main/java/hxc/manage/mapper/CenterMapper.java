package hxc.manage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

@Mapper
public interface CenterMapper {

    void editPwd(@Param("yzm") String yzm, @Param("newPwd") String newPwd, @Param("id") Long id);

    int changeInfo(@Param("map") Map<String, String> map);
}
