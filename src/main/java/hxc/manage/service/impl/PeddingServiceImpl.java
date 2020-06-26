package hxc.manage.service.impl;

import hxc.manage.common.EmailAndMessage;
import hxc.manage.common.JwtTokenProvider;
import hxc.manage.mapper.PeddingMapper;
import hxc.manage.model.Pedding;
import hxc.manage.model.Role;
import hxc.manage.model.User;
import hxc.manage.service.PeddingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author hxc
 * @version 1.0
 * @date 2019/12/12 14:17
 */
@Service
public class PeddingServiceImpl implements PeddingService {

    @Autowired
    PeddingMapper peddingMapper;

    @Autowired
    EmailAndMessage emailAndMessage;

    @Autowired
    JwtTokenProvider jwtTokenProvider;


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
            int length = peddingMapper.findIsManager(id,userId);//找有没有不是普通权限的
            if (length>0) {//非普通用户的
                ma1 = peddingMapper.getPeddingName(id,size,start);
            }
            else{
                ma2 = peddingMapper.getPeddingName2(userId,size,start);//普通用户的
            }
        }
        ma1.addAll(ma2);
        Map<String,Object> res = new HashMap<>();
        res.put("list",ma1);
        res.put("count",ma1.size());
        return res;

    }



    //发送消除待办
    public int sendPedding(HttpServletRequest req,
                                           String tableId,
                                           String type,//个人or集体;1,2
                                           String agree,//0 -- 不同意 1 -- 同意
                                           String state) {//  tableName 到哪个阶段了1首次发起2教研室3分院4返回修改在发起
        int res;
        String token = req.getHeader("Authorization");
        User user =jwtTokenProvider.getUserFromToken(token);
        String userId =user.getId()+"";
        //第一次直接插入记录就好
        Pedding pedding = new Pedding();
        if (state.equals("1")) {
            pedding.setType(type);//个人or集体;1,2
            pedding.setMain("有一条申请需要审核");
            pedding.setName("审核");
            pedding.setState("0");
            pedding.setTableId(tableId);
            pedding.setUrl("/audit/ResearchAudit");
            pedding.setOperator(userId);
            pedding.setCreateTime(new Date().getTime() + "");
            res = send(pedding, userId, "", state);

        }else{
            pedding.setUpdateTime(new Date().getTime()+"");
            pedding.setTableId(tableId);
            res = send(pedding,userId,agree,state);

        }
        return res;
    }
//    待办发送

    /**
     * 第一次插入之后查找然后update
     * @param userId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public Integer send(Pedding pedding,String userId,String agree,String state) {

        /**
         * 分院的需要页面给参数到第几阶段直接给值 tableName 2  ---3
         * 每次跟新完返回手机号发送短信
         */
        int res;
        //第一次插入
        if (state.equals("1")) {
            String roleid = peddingMapper.findPeddingRole(userId);//当前用户给哪个权限的发送消息--教研室
            pedding.setRole(roleid);
            Pedding p = new Pedding();
            res = peddingMapper.sendPedding(pedding);
            sendMailAndPhone(pedding.getRole());
        }
//        tableName 2 -- 教研室审批 3 -- 分院 4 -- 返回修改的
//        agree 0 -- 不同意 1 -- 同意
        else if (state.equals("2")){
            if (agree.equals("0")){//教研室不同意
                pedding.setRole(peddingMapper.findPeddingRole(userId));
                pedding.setMain("有一条审核未通过");
                pedding.setState("2");
                res = peddingMapper.updatePedding(pedding);
                sendMailAndPhone(pedding.getRole());
            }else{//教研室同意
                pedding.setRole("6");
                pedding.setState("1");
                res = peddingMapper.updatePedding(pedding);
                sendMailAndPhone(pedding.getRole());
            }
        }else if (state.equals("3")){
            if (agree.equals("0")){//分院不同意
                pedding.setState("4");
                res = peddingMapper.updatePedding(pedding);
//                sendMailAndPhone(pedding.getRole());
            }else{//分院同意
                pedding.setState("3");
                res = peddingMapper.updatePedding(pedding);
//                sendMailAndPhone(pedding.getRole());
            }
        }else{//返回修改的
            String roleid = peddingMapper.findPeddingRole(userId);//当前用户给哪个权限的发送消息--教研室
            pedding.setRole(roleid);
            pedding.setMain("有一条申请需要审核");
            pedding.setName("审核");
            pedding.setState("0");
            res = peddingMapper.updatePedding(pedding);
            sendMailAndPhone(pedding.getRole());
        }
        return res;
    }

    @Transactional(rollbackFor = Exception.class)
    void sendMailAndPhone(String role){
        Map<String,Object> map = peddingMapper.fingPhoneAndEmail(role);
        emailAndMessage.send(map.get("phone").toString(),"1");
        try {
            emailAndMessage.sendMail(map.get("email").toString());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }




}
