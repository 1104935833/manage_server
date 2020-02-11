package hxc.manage.mapper;

import hxc.manage.model.UserDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

@Mapper
public interface CenterMapper {

    void editPwd(@Param("yzm") String yzm, @Param("newPwd") String newPwd, @Param("id") Long id);


}
