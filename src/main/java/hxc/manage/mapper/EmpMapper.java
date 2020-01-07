package hxc.manage.mapper;

import hxc.manage.model.UserDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import hxc.manage.model.Nation;
import hxc.manage.model.PoliticsStatus;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author hxc
 * @version 1.0
 * @date 2019/12/27 14:26
 */
@Mapper
public interface EmpMapper {
    List<Nation> getAllNations();

    List<PoliticsStatus> getAllPolitics();

    int addEmp(UserDetails userDetails);

    Long getMaxWorkID();

    List<UserDetails> getEmployeeByPage(@Param("start") Integer start, @Param("size") Integer size, @Param("keywords") String keywords, @Param("politicId") Long politicId, @Param("nationId") Long nationId, @Param("posId") Long posId, @Param("jobLevelId") Long jobLevelId, @Param("engageForm") String engageForm, @Param("departmentId")Long  departmentId, @Param("startBeginDate") Date startBeginDate, @Param("endBeginDate") Date endBeginDate);

    Long getCountByKeywords(@Param("keywords") String keywords, @Param("politicId") Long politicId, @Param("nationId") Long nationId, @Param("posId") Long posId, @Param("jobLevelId") Long jobLevelId, @Param("engageForm") String engageForm, @Param("departmentId")Long  departmentId, @Param("startBeginDate") Date startBeginDate, @Param("endBeginDate") Date endBeginDate);

    int updateEmp(@Param("emp") UserDetails userDetails);

    int delByUserId(@Param("ids") String[] ids);

    int addEmps(@Param("emps") List<UserDetails> emps);

    List<UserDetails> getEmployeeByPageShort(@Param("start") int start, @Param("size") Integer size);

    List<UserDetails> getUserByPage(Map<String, Object> map);

    Integer getUserByCount(Map<String, Object> map);

    Integer getLastUserWorkId();

    void addUserDetails(UserDetails userDetails);

    Integer addUser(UserDetails userDetails);

    void editUser(UserDetails userDetails);
    void editUserDetails(UserDetails userDetails);
}
