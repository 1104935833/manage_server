package hxc.manage.service.impl;

import hxc.manage.mapper.SysRoleMapper;
import hxc.manage.model.Pedding;
import hxc.manage.model.Role;
import hxc.manage.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author hxc
 * @version 1.0
 * @date 2019/12/12 14:17
 */
@Service
public class SysRoleServiceImpl  implements SysRoleService {

    @Autowired
    SysRoleMapper sysRoleMapper;

//    public List<SysRole> findSysRole(){
//
//        return sysRoleMapper.findSysRole();
//    }

    //待办获取
    @Override
    public Map<String, Object> getPeddingName(List<Role> roles, String userId, int size, int start) {
        List<Pedding> ma1 = new ArrayList<>();
        List<Pedding> ma2 = new ArrayList<>();
        for (Role role : roles) {
            String id = role.getId()+"";
            if (id !="27") {//判断是不是普通用户的权限
                ma1 = sysRoleMapper.getPeddingName(id,size,start);
            }
            else{
                ma2 = sysRoleMapper.getPeddingName2(userId,size,start);//普通用户的
            }
        }
        ma1.addAll(ma2);
        Map<String,Object> res = new HashMap<>();
        res.put("list",ma1);
        res.put("count",ma1.size());
        return res;

    }
//    待办发送

    /**
     * 第一次插入之后查找然后update
     * @param userId
     * @return
     */
    public Integer sendPedding(Pedding pedding,String userId,String agree,String state){

        /**
         * 分院的需要页面给参数到第几阶段直接给值 state 2  ---3
         */
        int res;
        //第一次插入
        if (state.equals("1")) {
            String roleid = sysRoleMapper.findPeddingRole(userId);//当前用户给哪个权限的发送消息--教研室
            pedding.setRole(roleid);
            res = sysRoleMapper.sendPedding(pedding);
        }
//        state 2 -- 教研室审批 3 -- 分院 4 -- 返回修改的
//        agree 0 -- 不同意 1 -- 同意
        else if (state.equals("2")){
            if (agree.equals("0")){//教研室不同意
                pedding.setRole("27");
                pedding.setMain("有一条审核未通过");
                pedding.setState("2");
                res =sysRoleMapper.updatePedding(pedding);
            }else{//教研室同意
                pedding.setRole("6");
                pedding.setState("1");
                res =sysRoleMapper.updatePedding(pedding);
            }
        }else if (state.equals("3")){
            if (agree.equals("0")){//分院不同意
                pedding.setState("4");
                res =sysRoleMapper.updatePedding(pedding);
            }else{//分院同意
                pedding.setState("3");
                res =sysRoleMapper.updatePedding(pedding);
            }
        }else{//返回修改的
            String roleid = sysRoleMapper.findPeddingRole(userId);//当前用户给哪个权限的发送消息--教研室
            pedding.setRole(roleid);
            pedding.setMain("有一条xxx的需要审核");
            pedding.setName("审核");
            pedding.setState("0");
            res =sysRoleMapper.updatePedding(pedding);
        }


        return res;
    }




}
