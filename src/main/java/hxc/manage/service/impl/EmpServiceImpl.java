package hxc.manage.service.impl;

import hxc.manage.mapper.EmpMapper;
import hxc.manage.model.UserDetails;
import hxc.manage.model.Nation;
import hxc.manage.model.PoliticsStatus;
import hxc.manage.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author hxc
 * @version 1.0
 * @date 2019/12/27 14:26
 */
@Service
@Transactional
public class EmpServiceImpl implements EmpService {

    @Autowired
    EmpMapper empMapper;

    SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
    SimpleDateFormat birthdayFormat = new SimpleDateFormat("yyyy-MM-dd");
    DecimalFormat decimalFormat = new DecimalFormat("##.00");

    public List<Nation> getAllNations() {
        return empMapper.getAllNations();
    }

    public List<PoliticsStatus> getAllPolitics() {
        return empMapper.getAllPolitics();
    }



    public Long getMaxWorkID() {
        Long maxWorkID = empMapper.getMaxWorkID();
        return maxWorkID == null ? 0 : maxWorkID;
    }

    public int updateEmp(UserDetails userDetails) {
//        Date beginContract = userDetails.getBeginContract();
//        Date endContract = userDetails.getEndContract();
//        Double contractTerm = (Double.parseDouble(yearFormat.format(endContract)) - Double.parseDouble(yearFormat.format(beginContract))) * 12 + Double.parseDouble(monthFormat.format(endContract)) - Double.parseDouble(monthFormat.format(beginContract));
//        userDetails.setContractTerm(Double.parseDouble(decimalFormat.format(contractTerm / 12)));
        return empMapper.updateEmp(userDetails);
    }

    public boolean delByUserId(String ids) {
        String[] split = ids.split(",");
        return empMapper.delByUserId(split) == split.length;
    }

    public List<UserDetails> getAllEmployees() {
        return empMapper.getEmployeeByPage(null, null, "", null, null, null, null, null, null, null, null);
    }

    public int addEmps(List<UserDetails> emps) {
        return empMapper.addEmps(emps);
    }

    public List<UserDetails> getEmployeeByPageShort(Integer page, Integer size) {
        int start = (page - 1) * size;
        return empMapper.getEmployeeByPageShort(start,size);
    }

    @Override
    public List<UserDetails> getUserByPage(Map<String, Object> map) {

        return empMapper.getUserByPage(map);
    }

    @Override
    public Integer getUserByCount(Map<String, Object> map) {
        return empMapper.getUserByCount(map);

    }

    @Override
    public void addUser(UserDetails userDetails) {
        Integer workId = empMapper.getLastUserWorkId();
        userDetails.setWorkID(workId+1);
        empMapper.addUser(userDetails);
        empMapper.addUserDetails(userDetails);

    }

    @Override
    public void editUser(UserDetails userDetails) {
        empMapper.editUser(userDetails);
        empMapper.editUserDetails(userDetails);
    }
}
