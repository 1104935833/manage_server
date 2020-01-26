package hxc.manage.controller.system;

import hxc.manage.model.RespBean;
import hxc.manage.model.Role;
import hxc.manage.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hxc
 * @version 1.0
 * @date 2020/1/19 16:07
 */
@RestController
@RequestMapping("/system/part")
public class SystemPartController {

    @Autowired
    PartService partService;

    @PostMapping("/addPart")
    public RespBean addPart(@RequestParam("name") String name, @RequestParam("nameZh") String nameZh){
        try{
            partService.addPart(name,nameZh);
            return RespBean.ok("添加成功!");
        }catch (Exception e){
            e.printStackTrace();
            return RespBean.error("添加失败!");
        }

    }

    @GetMapping("/getTrandferUser")
    public Map<String, List> getTrandferUser(@RequestParam("rid") String rid){
        Map<String,List> map = partService.getTrandferUser(rid);
        return map;
    }

    //    分配用户
    @PostMapping("/editPartUser")
    public RespBean editPartUser(@RequestParam(value = "parts",required=false) List parts,
                                 @RequestParam(value = "partId",required=false) Integer partId){
        try {
            partService.editPartUser(parts,partId);
            return RespBean.ok("修改成功！");
        }catch (Exception e){
            e.printStackTrace();
            return RespBean.error("修改失败！");
        }
    }



    //    编辑权限
    @PostMapping("/editPart")
    public RespBean editPart(@RequestBody Map map){
        try {
            partService.editPart(map);


            return RespBean.ok("修改成功！");
        }catch (Exception e){
            e.printStackTrace();
            return RespBean.error("修改失败！");
        }
    }
    //删除角色
    @GetMapping("/delPart")
    public RespBean delPart(@RequestParam("id") String id,
                            @RequestParam("state") Integer state){
        try {
            partService.delPart(id,state);
            return RespBean.ok("操作成功！");
        }catch (Exception e){
            e.printStackTrace();
            return RespBean.error("操作失败！");
        }
    }

    //获取角色对应的菜单和目录
    @GetMapping("/getPartMenuById")
    public Map<String ,Object> getPartMenuById(@RequestParam("id") String id) {
        Map<String,Object> l= partService.getPartMenuById(id);



        return l;
    }


    //获取所有权限列表
    @GetMapping("/getAllRole")
    public Map<String ,Object> getAllRole(){
        List<Role> role = partService.getAllRole();
        Map<String, Object> map= new HashMap<>();
        map.put("role",role);
        return map;
    }


}